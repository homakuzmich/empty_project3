package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import practice.Application;
import practice.dao.office.OfficeDao;
import practice.model.Office;
import practice.model.Organization;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDaoTest {

    @Autowired
    private OfficeDao officeDao;

    @Test
    public void test(){
        Office office=new Office();
        Set<Organization> list=new HashSet<>();
        office.setActive(true);
        office.setId(1L);
        office.setName("Бизнес-центр Дружба");
        office.setAddress("Москва,ул. Новослободская, 6");
        Organization organization=new Organization("Жуки","ОАО Жуки","7723991101","772001001","Москва.ул. Золотая, 28","(495)242-0100",true);
        organization.addOffice(office);
        office.setOrganizations(list);
        list.add(organization);

        officeDao.save(office);

        List<Office> offices=officeDao.all();
        Assert.assertNotNull(offices);

        organization.addOffice(office);
        Assert.assertFalse(offices.isEmpty());

        Set<Organization> organizations=offices.get(1).getOrganizations();
        Assert.assertNotNull(organizations);
        Assert.assertEquals(1,organizations.size());

        Organization next=new Organization("Чудеса","ОАО Чудеса","7754383749","772001001","Москва, ул. 3-я Владимирская, 21","(800)201-0012",true);

        list.add(next);
        offices=officeDao.all();
        organizations = offices.get(1).getOrganizations();
        Assert.assertNotNull(office);
        Assert.assertEquals(1,organizations.size());
    }

}