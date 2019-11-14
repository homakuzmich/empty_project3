package practice.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
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
    public User update(Long id, String firstName, String lastName, String middleName, String position, String phone, Boolean isIdentified) throws Exception {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new Exception("Пользователь не существует!");
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setPhone(phone);
        user.setPosition(position);
        user.setIdentified(isIdentified);

        em.flush();
        return user;
    }


    @Override
    public void save(User user) {
        em.persist(user);
    }
}
