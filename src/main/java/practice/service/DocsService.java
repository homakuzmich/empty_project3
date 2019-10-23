package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.DocsView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocsService {
    void add(@Valid DocsView document);

    List<DocsView> documents();
}