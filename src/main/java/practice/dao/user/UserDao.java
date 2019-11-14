package practice.dao.user;

import practice.model.User;

import java.util.List;

public interface UserDao {
    List<User> all();

    User loadById(Long id);

    User update(Long id, String firstName, String lastName, String middleName, String position, String phone, Boolean isIdentified) throws Exception;

    void save(User user);
}
