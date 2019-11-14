package practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import practice.service.UserService;
import practice.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController", description = "Управление информацией о людях")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Добавить нового человека", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public void userAdd(@RequestBody UserView user){
        userService.addAndSave(user);
    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
    @GetMapping("/user/list")
    public List<UserView> list() {
        return userService.users();
    }

    @ApiOperation(value = "Загрузить по id", httpMethod = "GET")
    @GetMapping(path = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserView loadById(UserView user, @PathVariable Long id) {
        return userService.loadById(user, id);
    }

    @ApiOperation(value = "Обновить информацию о пользователе", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/user/{id}/update", consumes = "application/json", produces = "application/json")
    public void userUpdate(@RequestBody UserView user) throws Exception {
        userService.update(user);
    }
}
