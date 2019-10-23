package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.OrganizationView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {
    void add(@Valid OrganizationView organization);

    List<OrganizationView> organizations();
}
