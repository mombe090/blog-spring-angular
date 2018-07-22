package com.mombesoft.springbootvuejs.main.controllers;

import com.mombesoft.springbootvuejs.main.entities.User;
import com.mombesoft.springbootvuejs.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity index() {
        List<User> users = this.userService.getUsers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(Arrays.asList(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity store(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity show(@PathVariable int id) {
        User user = this.userService.getUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new EmptyClass(), HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody User user) {
        if (user.getPassword().length() != 0)
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity destroy(@PathVariable int id) {
        String msg = this.userService.deleteUser(id);

        return new  ResponseEntity<>( msg, HttpStatus.ACCEPTED);
    }

}