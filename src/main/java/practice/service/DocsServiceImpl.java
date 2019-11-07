package practice.service;


import ma.glasnost.orika.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.docs.DocsDao;
import practice.model.Docs;
import practice.model.mapper.MapperFacade;
import practice.view.DocsView;

import javax.validation.Valid;
import java.util.List;

@Service
public class DocsServiceImpl implements DocsService {

    private final DocsDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocsServiceImpl(DocsDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void addAndSave(DocsView view) {
        Docs document = new Docs(view.code, view.name, view.date);
        dao.save(document);
    }

    @Override
    @Transactional(readOnly=true)
    public List<DocsView> documents() {
        List<Docs> all=dao.all();
        return mapperFacade.mapAsList(all, DocsView.class);
    }

    @Override
    @Transactional
    public void update(DocsView view) {
        dao.update(view.code, view.name, view.date);
    }

    @Override
    @Transactional(readOnly = true)
    public DocsView loadById(DocsView document, Long id) {
        Docs doc = dao.loadById(id);
        return mapperFacade.map(doc, DocsView.class);
    }
}
