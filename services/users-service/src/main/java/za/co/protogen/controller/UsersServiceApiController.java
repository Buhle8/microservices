package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersServiceApiController {
    private final UserService userService;


    public UsersServiceApiController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);

    }

    @DeleteMapping("/{id}")
    public void removeUserById(@PathVariable Long id) {
        userService.removeUser(id);

    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @GetMapping("/searchUsers")
    public List<User> searchUsers(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "dateOfBirth", required = false) LocalDate dateOfBirth,
            @RequestParam(name = "rsaId", required = false) String rsaId
    ) {
        return userService.searchUsers(id, firstName, lastName, dateOfBirth, rsaId);
    }
}

