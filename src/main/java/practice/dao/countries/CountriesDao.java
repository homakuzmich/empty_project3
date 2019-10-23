package practice.dao.countries;

import practice.model.Countries;

import java.util.List;

public interface CountriesDao {
    List<Countries> all();

    Countries loadById(Long code);

    void update(Countries country);

    void save(Countries country);
}
