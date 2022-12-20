package com.netflix.backend.DTO;

import com.netflix.backend.entities.constants.ProfileType;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class ProfileDTO {
    private String profileId;
    @NotEmpty(message = "Profile name cannot be empty") //s5 20
    private String name;
    private ProfileType profileType;
    private Date createdAt;
    private String userId;

    public ProfileDTO() {
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
}
