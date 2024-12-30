package com.SpringTest.SpringTest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringTest.SpringTest.entity.User;
import com.SpringTest.SpringTest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable Integer id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Integer id){
        boolean ok = userService.deleteUserById(id);

        if(ok){
            return "User with id: " + id + " deleted";
        }
        else{
            return "There is no user with id " + id;
        }
    }
}
