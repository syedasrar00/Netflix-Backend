package com.netflix.backend.controllers;

import com.netflix.backend.DTO.UserObject;
import com.netflix.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/user")
    public String createUser(@RequestBody UserObject user){
        return userServices.createUser(user);
    }
    @GetMapping("/all")
    public List<UserObject> getAllUsers(){return userServices.userList();}
}
