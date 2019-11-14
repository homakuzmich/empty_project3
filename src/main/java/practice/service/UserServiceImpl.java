package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.user.UserDao;
import practice.model.User;
import practice.model.mapper.MapperFacade;
import practice.view.UserView;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void addAndSave(UserView view) {
        User user=new User(view.firstName,view.lastName,view.middleName,view.position,view.phone,view.isIdentified);
        dao.save(user);
    }

    @Override
    @Transactional
    public List<UserView> users() {
        List<User> all = dao.all();
        return mapperFacade.mapAsList(all, UserView.class);
    }

    @Override
    @Transactional
    public void update(UserView view) throws Exception {
        dao.update(view.id, view.firstName, view.lastName, view.middleName, view.position, view.phone, view.isIdentified);
    }

    @Override
    @Transactional(readOnly = true)
    public UserView loadById(UserView user, Long id) {
        User useful = dao.loadById(id);
        return mapperFacade.map(useful, UserView.class);
    }
}