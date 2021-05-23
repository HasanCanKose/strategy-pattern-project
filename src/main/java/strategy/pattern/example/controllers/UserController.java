package strategy.pattern.example.controllers;

import org.springframework.web.bind.annotation.*;
import strategy.pattern.example.models.User;
import strategy.pattern.example.services.UserService;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{email}")
    public User getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id) {
        userService.updateUser(user, Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(Integer.parseInt(id));
    }
}
