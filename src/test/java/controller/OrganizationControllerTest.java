package controller;

import ma.glasnost.orika.MappingException;
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
import practice.controller.OrganizationController;
import practice.dao.organization.OrganizationDao;
import practice.model.Organization;
import practice.view.OrganizationView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationControllerTest {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private OrganizationController organizationController;

    public OrganizationControllerTest() {
    }

    @Test
    public void test() {
        try {
            Organization organization = new Organization(1L, "Росатом", "ОАО Росатом", "7734560980", "773001001", "Москва,Кутузовский проспект, 32", "(495)791-1010", true);
            Set<Organization> companies = new HashSet<>();
            companies.add(organization);
            Assert.assertNotNull(companies);
            Assert.assertEquals(1, companies.size());

            organizationDao.save(organization);
            List<Organization> organizations = organizationDao.all();
            Assert.assertEquals(4, organizations.size());

            OrganizationView nextOrganization = new OrganizationView(6L, "Ромашка", "ООО Ромашка", "7732701564", "772001001", "Москва, ул. Беловежская, 3", "(499)999-5599", false);
            organizationController.organizationAdd(nextOrganization);
            List<OrganizationView> newList = organizationController.list();
            Assert.assertNotNull(newList);
            Assert.assertEquals(5, newList.size());

            nextOrganization.setName("Снегирь");
            nextOrganization.setFullName("ОАО Снегирь");
            nextOrganization.setActive(true);
            organizationController.organizationUpdate(nextOrganization);
            organizationController.organizationAdd(nextOrganization);
        } catch (MappingException e) {
            e.getLocalizedMessage();
        }
    }
}
