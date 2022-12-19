package com.netflix.backend.services;

import com.netflix.backend.DTO.ProfileDTO;

public interface ProfileService {
    void addProfile(ProfileDTO profile);
    String deleteProfile(String profileId);
}
