package practice.dao.countries;

import practice.model.Countries;

import java.util.List;

public interface CountriesDao {
    List<Countries> all();

    Countries loadById(Long code);

    long update(Long code, String name);

    void save(Countries country);
}
