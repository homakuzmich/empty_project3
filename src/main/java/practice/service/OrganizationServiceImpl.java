package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.organization.OrganizationDao;
import practice.model.Organization;
import practice.model.mapper.MapperFacade;
import practice.view.OrganizationView;

import javax.validation.Valid;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void addAndSave(OrganizationView view) {
        Organization organization=new Organization(view.name,view.fullName,view.inn,view.kpp,view.address,view.phone,view.isActive);
        dao.save(organization);
    }

    @Override
    @Transactional
    public List<OrganizationView> organizations() {
        List<Organization> all=dao.all();
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }

    @Override
    @Transactional
    public void update(OrganizationView view) throws Exception {
        dao.update(view.id, view.name, view.fullName, view.inn, view.kpp, view.address, view.phone, view.isActive);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView loadById(OrganizationView view, Long id) {
        Organization organization = dao.loadById(id);
        return mapperFacade.map(organization, OrganizationView.class);
    }
}