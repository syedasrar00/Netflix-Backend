package com.netflix.backend.DTO;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

public class ProfileObject {
    @NotEmpty(message = "Profile name cannot be empty")
    private String name;

    public ProfileObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
