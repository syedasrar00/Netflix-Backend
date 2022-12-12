package com.netflix.backend.security;

import org.springframework.stereotype.Service;

@Service
public class UserInSession {

    private String userName;

    public UserInSession() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
