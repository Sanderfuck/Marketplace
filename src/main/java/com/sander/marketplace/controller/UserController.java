package com.sander.marketplace.controller;

import com.sander.marketplace.exception.UserNotFoundException;
import com.sander.marketplace.model.User;
import com.sander.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        User userById = userService.getUserById(id);
        if (userById == null) throw new UserNotFoundException();
        return userById;
    }

    @PostMapping("/users")
    public User createUser(User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }
}
