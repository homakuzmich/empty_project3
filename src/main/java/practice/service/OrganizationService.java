package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.OrganizationView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {
    void addAndSave(OrganizationView organization);

    List<OrganizationView> organizations();

    void update(@Valid OrganizationView organization);

    OrganizationView loadById(OrganizationView view, Long id);
}
