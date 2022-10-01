package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.entity.User;
import cinema.tickets.booking.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        userService.save(user);

        return user;
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        userService.save(user);

        return user;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        userService.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
