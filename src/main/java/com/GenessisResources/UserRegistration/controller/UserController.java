package com.GenessisResources.UserRegistration.controller;

import com.GenessisResources.UserRegistration.model.User;
import com.GenessisResources.UserRegistration.model.UserSimple;
import com.GenessisResources.UserRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List getAllUsers(@RequestParam(required = false) Boolean detail){
        if(detail == null || !detail) {
            return userService.getAllUsersSimple();
        }else {
            return userService.getAllUsers();
        }
    }

    @GetMapping("/{id}")
    public Optional<UserSimple> getUser(@PathVariable Integer id, @RequestParam(required = false) Boolean detail){
        if(detail == null || !detail) {
            return userService.getUserSimple(id);
        }else {
            return userService.getUser(id).map(user -> (UserSimple) user);
        }
    }
}
