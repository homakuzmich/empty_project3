package controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import practice.Application;
import practice.controller.UserController;
import practice.dao.user.UserDao;
import practice.model.User;
import practice.view.UserView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserDao userDao;

    public UserControllerTest() {
    }

    @Test
    public void test() {
        User user = new User(1L, "Андрей", "Иванов", "Николаевич", "Менеджер", "(495)277-0101", true);
        Set<User> list = new HashSet<>();
        list.add(user);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());

        userDao.save(user);
        List<User> spisok = userDao.all();
        Assert.assertEquals(5, spisok.size());

        UserView user2 = new UserView(7L, "Андрей", "Иванов", "Иванович", "Управляющий", "(800)555-3535", true, "3");
        userController.userAdd(user2);
        List<UserView> spisok2 = userController.list();
        Assert.assertNotNull(spisok2);
        Assert.assertEquals(6, spisok2.size());

        user2.setMiddleName("Алексеевич");
        user2.setLastName("Миронов");
        user2.setFirstName("Иван");
        user2.setIsIdentified(false);
        user2.setPhone("(495)342-0212");
        user2.setPosition("Поехавший");
        userController.userAdd(user2);
        userController.userUpdate(user2);

    }
}
