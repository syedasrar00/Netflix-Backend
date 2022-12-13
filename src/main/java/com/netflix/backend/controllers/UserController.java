package com.netflix.backend.controllers;

import com.netflix.backend.DTO.UserObject;
import com.netflix.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserObject userObject){
        return new ResponseEntity<>(userServices.createUser(userObject), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserObject>> getAllUsers(){return new ResponseEntity<>(userServices.userList(),HttpStatus.OK);}
}
