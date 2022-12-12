package com.netflix.backend.Authentication;

public class UserAuthenticationResponse {
    private final String jwt;

    public UserAuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
