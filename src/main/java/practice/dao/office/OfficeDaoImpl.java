package practice.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> all() {
        TypedQuery<Office> query=em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office loadById(Long id) {
        return em.find(Office.class,id);
    }

    @Override
    public void update(Office office) {
        Query query=em.createQuery("UPDATE Office SET id=?, name=?, address=?" +
                "WHERE id=? AND version=?");
        query.executeUpdate();
    }

    @Override
    public void save(Office office) {
        em.persist(office);
        }

    }
