package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.office.OfficeDao;
import practice.model.Office;
import practice.model.mapper.MapperFacade;
import practice.view.OfficeView;

import javax.validation.Valid;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }


    @Override
    @Transactional
    public void addAndSave(OfficeView view) {
        Office office=new Office(view.name,view.address,view.phone,view.isActive);
        dao.save(office);
    }

    @Override
    @Transactional
    public List<OfficeView> offices() {
        List<Office> all=dao.all();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }

    @Override
    @Transactional
    public void update(OfficeView view) throws Exception {
        dao.update(view.id, view.name, view.address, view.phone, view.isActive);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView loadById(OfficeView view, Long id) {
        Office office = dao.loadById(id);
        return mapperFacade.map(office, OfficeView.class);
    }
}
