import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import practice.Application;
import practice.dao.user.UserDao;
import practice.model.Office;
import practice.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        User user=new User();
        Set<Office> offices=new HashSet<>();
        user.setFirstName("Алексей");
        Office office=new Office("Рога и копыта","ул. Строителей,5","(499)133-22-12",true,1L);
        office.addUser(user);
        offices.add(office);
        userDao.save(user);

        List<User> users= userDao.all();
        Assert.assertNotNull(users);

        office.addUser(user);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(1,users.size());

        Office officeOther=new Office("ООО Ромашка","ул. Строителей,28","(499)249-05-49",false,2L);
        offices.add(officeOther);

        users=userDao.all();
        Assert.assertNotNull(office);
        Assert.assertEquals(2,offices.size());

    }
}