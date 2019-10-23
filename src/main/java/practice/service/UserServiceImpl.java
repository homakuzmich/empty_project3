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

    @Autowired
    private final UserDao dao;
    private final MapperFacade mapperFacade;

    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void add(UserView view) {
        User user=new User(view.firstName,view.lastName,view.middleName,view.position,view.phone,view.isIdentified);
        dao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> users() {
        List<User> all = dao.all();
        return mapperFacade.mapAsList(all, UserView.class);
    }
}