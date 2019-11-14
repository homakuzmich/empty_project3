package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.CountriesView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CountriesService {
    void addAndSave(/*@Valid*/ CountriesView country);

    List<CountriesView> countries();

    void update(@Valid CountriesView country) throws Exception;

    CountriesView loadById(CountriesView country, Long id);
}