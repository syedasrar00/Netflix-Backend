package com.netflix.backend.DTO;

import com.netflix.backend.entities.Profile;
import com.netflix.backend.entities.History;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserObject {

    private long id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @Email(message = "Not a valid email.")
    private String email;
    @NotEmpty
    @Size(min=8, max=25, message ="password length must be between 8-25 characters")
    private String password;
    @NotEmpty
    @Size(min=10, message="Phone number cannot be at less than 10 characters")
    private String phoneNumber;
    private List<Profile> profiles = new ArrayList<>();
    private List<History> watchHistories = new ArrayList<>();
    public UserObject() {
    }

    public List<History> getWatchHistories() {
        return watchHistories;
    }

    public void setWatchHistories(List<History> watchHistories) {
        this.watchHistories = watchHistories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}