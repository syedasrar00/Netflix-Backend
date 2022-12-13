package com.netflix.backend.DTO;

import javax.validation.constraints.*;
import java.util.UUID;

public class UserObject {
    private UUID id;
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

    public UserObject() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}