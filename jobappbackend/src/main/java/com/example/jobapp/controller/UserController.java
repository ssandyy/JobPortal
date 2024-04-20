package com.example.jobapp.controller;

import com.example.jobapp.model.User;
import com.example.jobapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/addUser")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/findUser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/findAllUsers")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @PutMapping("/userUpdate")
    public User UpdateUser(@RequestBody User user) {
        return userService.userUpdate(user);
    }

    @DeleteMapping("/userDelete/{id}")
    public User DeleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

}
