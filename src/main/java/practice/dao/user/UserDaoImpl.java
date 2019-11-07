package practice.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import practice.model.User;

import javax.persistence.EntityManager;
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
    public long update(Long id, String firstName, String lastName, String middleName, String position, String phone, Boolean isIdentified) {
        User u = em.find(User.class, id);
        if (u == null) {
            return 0;
        }
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setMiddleName(middleName);
        u.setPosition(position);
        u.setPhone(phone);
        u.setIdentified(isIdentified);

        em.flush();
        return 1;

    }

    @Override
    public void save(User user) {
        em.persist(user);
    }
}
