package com.netflix.backend.services;

import com.netflix.backend.DTO.ProfileObject;

public interface ProfileService {
    void addProfile(ProfileObject profile);
    String deleteProfile(int profileId);
}
