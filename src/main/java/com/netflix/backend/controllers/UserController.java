package com.netflix.backend.controllers;


import com.netflix.backend.DTO.UserDTO;
import com.netflix.backend.entities.constants.UserRole;
import com.netflix.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userObject){
        return new ResponseEntity<>(userServices.createUser(userObject), HttpStatus.OK);
    }
    @PostMapping("/user/subscription")
    @Secured(UserRole.ROLE_USER)
    public ResponseEntity<String> activateSubscription(){
        return ResponseEntity.ok(userServices.activateSubscription());
    }
    @DeleteMapping("/user/subscription")
    @Secured(UserRole.ROLE_CUSTOMER)
    public ResponseEntity<String> deactivateSubscription(){
        return ResponseEntity.ok(userServices.deactivateSubscription());
    }
}
