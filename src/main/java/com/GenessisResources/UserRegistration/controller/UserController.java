package com.GenessisResources.UserRegistration.controller;

import com.GenessisResources.UserRegistration.model.User;
import com.GenessisResources.UserRegistration.model.UserSimple;
import com.GenessisResources.UserRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

/*    @GetMapping("/{id}")
    public UserSimple getUser(@RequestParam(required = false) Boolean detail){

    }*/
}
