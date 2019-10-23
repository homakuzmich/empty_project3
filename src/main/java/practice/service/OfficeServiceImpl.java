package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.office.OfficeDao;
import practice.model.Office;
import practice.model.mapper.MapperFacade;
import practice.view.OfficeView;

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
    public void add(OfficeView view) {
        Office office=new Office(view.name,view.address,view.phone,view.isActive);
        dao.save(office);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices() {
        List<Office> all=dao.all();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }
}
