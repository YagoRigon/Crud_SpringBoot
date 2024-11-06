package com.example.users.api;

import com.example.users.model.User;
import com.example.users.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInputStream;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
@Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.GetUserById(id);
        return (User) user.orElse(null);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User added = userService.addUser(user);
            return new ResponseEntity<>(added, HttpStatus.CREATED);

    }
}
