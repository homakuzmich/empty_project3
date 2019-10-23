package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.countries.CountriesDao;
import practice.model.Countries;
import practice.model.mapper.MapperFacade;
import practice.view.CountriesView;

import java.util.List;

@Service
public class CountriesServiceImpl implements CountriesService {

    private final CountriesDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountriesServiceImpl(CountriesDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(CountriesView view) {
        Countries country= new Countries(view.name);
        dao.save(country);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountriesView> countries() {
        List<Countries> all=dao.all();
        return mapperFacade.mapAsList(all, CountriesView.class);
    }
}
