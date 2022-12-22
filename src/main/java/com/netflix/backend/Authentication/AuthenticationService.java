package com.netflix.backend.Authentication;


import com.netflix.backend.entities.Token;
import com.netflix.backend.entities.User;
import com.netflix.backend.exceptions.InvalidCredentialsException;
import com.netflix.backend.security.AppUserDetailsService;
import com.netflix.backend.security.JwtUtil;
import com.netflix.backend.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {
    @Autowired
    private AppUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private JwtUtil jwtUtil;

    public String validateUser(UserAuthenticationRequest authenticationRequest) throws InvalidCredentialsException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        final UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwtToken = jwtUtil.generateToken(user);
        System.out.println("before");
        Token token = tokenService.getToken(user.getUsername());
        if(token==null){
            System.out.println("null");
            tokenService.createToken(UUID.randomUUID().toString(), user.getUsername(), jwtToken);
        }else{
            token.setJwt(jwtToken);
            System.out.println(token.getUserName()+" "+token.getJwt()+" "+token.getToken());
            tokenService.updateToken(token);
        }
        return jwtToken;
    }
    public String unValidateUser(String jwtToken){
        Token token = tokenService.getTokenByJwt(jwtToken);
        tokenService.deleteToken(token);
        return "Logout successful";
    }
}
