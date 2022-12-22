package com.netflix.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Token {
    @Id
    @Column(name = "profile_id", updatable = false, nullable = false)
    private String token;
    private String userName;
    private String jwt;

    public Token(String token, String userName, String jwt) {
        this.token = token;
        this.userName = userName;
        this.jwt = jwt;
    }

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
