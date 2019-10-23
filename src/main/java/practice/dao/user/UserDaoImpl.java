package practice.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> all() {
        TypedQuery<User> query=em.createQuery("SELECT u FROM User u",User.class);
        return query.getResultList();
    }

    @Override
    public User loadById(Long id) {
        return em.find(User.class,id);
    }

    @Override
    public void update(User user) {
        Query query=em.createQuery("UPDATE User SET id=?, firstName=?, position=?" +
                "WHERE id=? AND version=?");
        query.executeUpdate();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }
}
