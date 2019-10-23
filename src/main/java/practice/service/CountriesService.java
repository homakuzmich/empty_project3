package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.CountriesView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CountriesService {
    void add(@Valid CountriesView country);

    List<CountriesView> countries();
}