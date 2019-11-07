package practice.dao.organization;

import practice.model.Organization;

import java.util.List;

public interface OrganizationDao {
    List<Organization> all();

    Organization loadById(Long id);

    long update(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive);

    void save(Organization organization);
}
