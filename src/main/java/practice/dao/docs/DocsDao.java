package practice.dao.docs;

import practice.model.Docs;

import java.util.List;

public interface DocsDao {
    List<Docs> all();

    Docs loadById(Long id);

    void update(Docs document);

    void save(Docs document);
}
