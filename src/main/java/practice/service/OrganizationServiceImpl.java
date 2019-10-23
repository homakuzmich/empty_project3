package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.organization.OrganizationDao;
import practice.model.Organization;
import practice.model.mapper.MapperFacade;
import practice.view.OrganizationView;

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
    public void add(OrganizationView view) {
        Organization organization=new Organization(view.name,view.fullName,view.inn,view.kpp,view.address,view.phone,view.isActive);
        dao.save(organization);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> organizations() {
        List<Organization> all=dao.all();
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }
}