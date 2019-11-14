package practice.dao.organization;

import practice.model.Organization;

import java.util.List;

public interface OrganizationDao {
    List<Organization> all();

    Organization loadById(Long id);

    Organization update(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) throws Exception;

    void save(Organization organization);
}
