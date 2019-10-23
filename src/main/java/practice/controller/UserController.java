package practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.service.UserService;
import practice.view.UserView;

import java.util.List;

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
    @PostMapping("/user")
    public void userAdd(@RequestBody UserView user){
        userService.add(user);
    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
    @GetMapping("/user")
    public List<UserView> list() {
        return userService.users();
    }
}
