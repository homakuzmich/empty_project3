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
import practice.controller.DocsController;
import practice.dao.docs.DocsDao;
import practice.model.Docs;
import practice.view.DocsView;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class DocsControllerTest {

    @Autowired
    private DocsController docsController;

    @Autowired
    private DocsDao docsDao;

    public DocsControllerTest() {
    }

    @Test
    public void test() {
        try {
            Docs document = new Docs();
            document.setCode(5L);
            document.setName("Загранпаспорт");
            document.setDate(new Date(16 - 04 - 2013));

            Set<Docs> list = new HashSet<>();
            list.add(document);

            Assert.assertNotNull(document);
            Assert.assertEquals(1, list.size());

            List<Docs> spisok = docsDao.all();
            spisok.add(document);
            Assert.assertEquals(5, spisok.size());

            DocsView nextDocument = new DocsView(5L, "Паспорт моряка");
            Collection<DocsView> spisok2 = docsController.list();
            spisok2.add(nextDocument);
            Assert.assertNotNull(spisok2);
            Assert.assertEquals(5, spisok2.size());

            nextDocument.setCode(5L);
            nextDocument.setDate(new Date(12 - 01 - 2017));
            nextDocument.setName("Загранпаспорт");

            docsController.docsUpdate(nextDocument);
        } catch (MappingException e) {
            e.getLocalizedMessage();
        }

    }
}
