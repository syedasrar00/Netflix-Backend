package com.netflix.backend.controllers;

import com.netflix.backend.Authentication.AuthenticationService;
import com.netflix.backend.Authentication.UserAuthenticationRequest;
import com.netflix.backend.exceptions.InvalidCredentialsException;

import com.netflix.backend.entities.constants.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> createAuthenticationToken(@RequestBody UserAuthenticationRequest authenticationRequest) throws Exception, InvalidCredentialsException {
        return ResponseEntity.ok(authenticationService.validateUser(authenticationRequest));
    }
    @PostMapping("/logoutUser")
    @Secured({UserRole.USER,UserRole.CUSTOMER})
    public ResponseEntity<String> removeAuthenticationToken(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(authenticationService.unValidateUser(token));
    }
}