package com.netflix.backend.Authentication;

public class UserAuthenticationResponse {
    private String jwt;

    public UserAuthenticationResponse(){}

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
