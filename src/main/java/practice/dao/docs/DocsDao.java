package practice.dao.docs;

import practice.model.Docs;

import java.util.Date;
import java.util.List;

public interface DocsDao {
    List<Docs> all();

    Docs loadById(Long id);

    Docs update(Long code, String name, Date date) throws Exception;

    void save(Docs document);
}
