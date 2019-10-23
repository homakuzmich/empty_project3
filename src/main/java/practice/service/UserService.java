package practice.service;

import org.springframework.validation.annotation.Validated;
import practice.view.UserView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface UserService {
    void add(@Valid UserView user);

    List<UserView> users();
}
