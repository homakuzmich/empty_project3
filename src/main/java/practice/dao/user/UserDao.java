package practice.dao.user;

import practice.model.User;

import java.util.List;

public interface UserDao {
    List<User> all();

    User loadById(Long id);

    void update(User user);

    User save(User user);
}
