package practice.dao.user;

import practice.model.User;

import java.util.List;

public interface UserDao {
    List<User> all();

    User loadById(Long id);

    long update(Long id, String firstName, String lastName, String middleName, String position, String phone, Boolean isIdentified);

    void save(User user);
}
