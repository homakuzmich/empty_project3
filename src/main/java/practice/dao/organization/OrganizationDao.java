package practice.dao.organization;

import practice.model.Organization;

import java.util.List;

public interface OrganizationDao {
    List<Organization> all();

    Organization loadById(Long id);

    void update(Organization organization);

    Organization save(Organization organization);
}
