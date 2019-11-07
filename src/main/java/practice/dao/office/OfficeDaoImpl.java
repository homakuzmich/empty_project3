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
    public long update(Long id, String name, String address, String phone, Boolean isActive) {
        Office o = em.find(Office.class, id);
        if (o == null) {
            return 0;
        }
        o.setName(name);
        o.setAddress(address);
        o.setPhone(phone);
        o.setActive(isActive);

        em.flush();
        return 1;
    }


    @Override
    public void save(Office office) {
        em.persist(office);
        }

    }
