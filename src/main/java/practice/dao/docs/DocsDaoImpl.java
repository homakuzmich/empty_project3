package practice.dao.docs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.Docs;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class DocsDaoImpl implements DocsDao {

    private final EntityManager em;

    @Autowired
    public DocsDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Docs> all() {
        TypedQuery<Docs> query=em.createQuery("SELECT d FROM Docs d",Docs.class);
        return query.getResultList();
    }

    @Override
    public Docs loadById(Long code) {
        return em.find(Docs.class,code);
    }

    @Override
    public long update(Long code, String name, Date date) {
        Docs d = em.find(Docs.class, code);
        if (d == null) {
            return 0;
        }
        d.setName(name);
        d.setDate(date);
        em.flush();
        return 1;
    }

    @Override
    public void save(Docs document) {
        em.persist(document);
    }
}
