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
import practice.controller.OfficeController;
import practice.dao.office.OfficeDao;
import practice.model.Office;
import practice.view.OfficeView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeControllerTest {

    @Autowired
    private OfficeController officeController;

    @Autowired
    private OfficeDao officeDao;

    public OfficeControllerTest() {
    }

    @Test
    public void test() {
        try {
            Office office = new Office(1L, "Бизнес-центр Василек", "Москва, ул. Маршала Конева, 3", "(499)192-0200", false);
            Set<Office> offices = new HashSet<>();
            offices.add(office);
            Assert.assertNotNull(offices);
            Assert.assertEquals(1, offices.size());

            officeDao.save(office);
            List<Office> spisok = officeDao.all();
            Assert.assertEquals(4, spisok.size());

            OfficeView office2 = new OfficeView(5L, "Бизнес-центр Ильич", "Москва, ул. Сайкина, 3", "(495)363-2121", true);
            officeController.officeAdd(office2);
            List<OfficeView> spisok2 = officeController.list();
            Assert.assertNotNull(spisok2);
            Assert.assertEquals(5, spisok2.size());

            office2.setName("Бизнес-центр Ленин");
            officeController.officeUpdate(office2);
            officeController.officeAdd(office2);

        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }
}
