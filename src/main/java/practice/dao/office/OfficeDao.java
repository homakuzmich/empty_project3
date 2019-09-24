package practice.dao.office;

import practice.model.Office;

import java.util.List;

public interface OfficeDao {
    List<Office> all();

    Office loadById(Long id);

    void update(Office office);

    Office save(Office office);

}