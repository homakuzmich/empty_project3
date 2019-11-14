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
import practice.controller.CountriesController;
import practice.dao.countries.CountriesDao;
import practice.dao.user.UserDao;
import practice.model.Countries;
import practice.view.CountriesView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class CountriesControllerTest {

    public CountriesControllerTest() {
    }

    @Autowired
    private CountriesController countriesController;

    @Autowired
    private CountriesDao countriesDao;

    @Test
    public void test() {
        try {
            Countries country = new Countries();
            country.setCode(5L);
            country.setName("Австралия");
            Set<Countries> list = new HashSet<>();
            list.add(country);
            Assert.assertNotNull(list);
            Assert.assertEquals(1, list.size());

            List<Countries> spisok = countriesDao.all();
            spisok.add(country);
            Assert.assertEquals(5, spisok.size());

            CountriesView country2 = new CountriesView(6L, "Перу");
            List<CountriesView> spisok2 = countriesController.list();
            spisok2.add(country2);
            Assert.assertNotNull(spisok2);
            Assert.assertEquals(5, spisok2.size());

            country2.setName("Малайзия");
            country2.setCode(6L);
            countriesController.countriesUpdate(country2);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}