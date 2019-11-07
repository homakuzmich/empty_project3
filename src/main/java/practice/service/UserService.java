package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.UserView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface UserService {
    void addAndSave(/*@Valid*/ UserView user);

    List<UserView> users();

    void update(@Valid UserView user);

    UserView loadById(UserView user, Long id);
}
