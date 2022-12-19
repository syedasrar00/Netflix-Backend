package com.netflix.backend.controllers;

import com.netflix.backend.Authentication.AuthenticationService;
import com.netflix.backend.Authentication.UserAuthenticationRequest;
import com.netflix.backend.exceptions.InvalidCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserAuthenticationRequest authenticationRequest) throws Exception, InvalidCredentialsException {
        return ResponseEntity.ok(authenticationService.validateUser(authenticationRequest));
    }
}