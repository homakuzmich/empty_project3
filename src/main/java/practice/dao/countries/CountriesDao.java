package practice.dao.countries;

import practice.model.Countries;

import java.util.List;

public interface CountriesDao {
    List<Countries> all();

    Countries loadById(Long code);

    Countries update(Long code, String name) throws Exception;

    void save(Countries country);
}
