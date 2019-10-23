package practice.dao.docs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.Docs;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    public void update(Docs document) {
        Query query= em.createQuery("UPDATE Docs SET name = ? WHERE code=? AND version=? ");
        query.executeUpdate();
    }

    @Override
    public void save(Docs document) {
        em.persist(document);
    }
}
