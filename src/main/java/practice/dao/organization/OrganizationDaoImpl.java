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
    public Organization update(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) throws Exception {
        Organization o = em.find(Organization.class, id);
        if (o == null) {
            throw new Exception("Организация не существует!");
        }
        o.setId(id);
        o.setName(name);
        o.setFullName(fullName);
        o.setInn(inn);
        o.setKpp(kpp);
        o.setAddress(address);
        o.setPhone(phone);
        o.setActive(isActive);

        em.flush();
        return o;
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }
}
