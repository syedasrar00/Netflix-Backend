package com.netflix.backend.DTO;

import javax.validation.constraints.*;

public class UserDTO {

    private String userId;
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3,max = 20, message = "name must be between 3-20 characters")
    private String name;
    @Email(message = "Not a valid Email.")
    private String email;
    @NotEmpty
    @Size(min=8, max=25, message ="password length must be between 8-25 characters")
    private String password;
    @NotEmpty
    @Size(min=10, message="Phone number cannot be at less than 8 characters")
    private String phoneNumber;
    public UserDTO() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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