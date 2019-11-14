package practice.dao.office;

import practice.model.Office;

import java.util.List;

public interface OfficeDao {
    List<Office> all();

    Office loadById(Long id);

    Office update(Long id, String name, String address, String phone, Boolean isActive) throws Exception;

    void save(Office office);

}