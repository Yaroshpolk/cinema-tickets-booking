package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.entity.User;
import cinema.tickets.booking.api.exception.ResourceAlreadyExist;
import cinema.tickets.booking.api.exception.ResourceNotFoundException;
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
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User res = userService.getById(id);

        if (res != null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("User with id:%d not found", id));
        }
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.getById(user.getId()) == null) {
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        } else {
            throw new ResourceAlreadyExist(String.format("User with id:%d already exist", user.getId()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (userService.getById(user.getId()) != null) {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("User with id:%d not found", user.getId()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        User res = userService.getById(id);

        if (res != null) {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(String.format("User with id:%d not found", id));
        }
    }
}
