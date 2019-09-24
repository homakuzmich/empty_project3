package practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query=em.createQuery("SELECT o from Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class,id);
    }

    @Override
    public void update(Organization organization) {
        Query query=em.createQuery("UPDATE Organization SET id=?, name=?, fullName=?, inn=?, kpp=?, address=?" +
                "WHERE id=? AND version=?");
        query.executeUpdate();
    }

    @Override
    public Organization save(Organization organization) {
        if(organization.getId()== null){
            em.persist(organization);
        }
        else{
            em.merge(organization);
        }

        return organization;
    }
}
