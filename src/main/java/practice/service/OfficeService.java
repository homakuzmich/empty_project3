package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.OfficeView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OfficeService {
    void add(@Valid OfficeView office);

    List<OfficeView> offices();
}
