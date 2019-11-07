package practice.dao.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.Countries;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountriesDaoImpl implements CountriesDao {

    private final EntityManager em;

    @Autowired
    public CountriesDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Countries> all() {
        TypedQuery<Countries> query=em.createQuery("SELECT c FROM Countries c",Countries.class);
        return query.getResultList();
    }

    @Override
    public Countries loadById(Long code) {
        return em.find(Countries.class,code);
    }

    @Override
    public long update(Long code, String name) {
        Countries c = em.find(Countries.class, code);
        if (c == null) {
            return 0;
        }
        c.setName(name);
        em.flush();
        return 1;
    }


    @Override
    public void save(Countries country) {
        em.persist(country);
    }
}
