package practice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.docs.DocsDao;
import practice.model.Docs;
import practice.model.mapper.MapperFacade;
import practice.view.DocsView;

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
    public void add(DocsView view) {
        Docs document=new Docs(view.name,view.date);
        dao.save(document);
    }

    @Override
    @Transactional(readOnly=true)
    public List<DocsView> documents() {
        List<Docs> all=dao.all();
        return mapperFacade.mapAsList(all,DocsView.class);
    }
}
