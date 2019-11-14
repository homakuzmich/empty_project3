package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.model.Docs;
import practice.view.DocsView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocsService {
    void addAndSave(DocsView document);

    List<DocsView> documents();

    void update(@Valid DocsView document) throws Exception;

    DocsView loadById(DocsView document, Long id);
}