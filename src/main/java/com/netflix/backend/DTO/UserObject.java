package com.netflix.backend.DTO;

import javax.validation.constraints.*;

public class UserObject {
    @NotNull(message = "Name cannot be null")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Min(value = 8, message = "Password should not be less than 8 characters")
    @Max(value = 20, message = "Password should not be greater than 20 characters")
    private String password;
    @NotNull
    private String phoneNumber;

    public UserObject() {
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
