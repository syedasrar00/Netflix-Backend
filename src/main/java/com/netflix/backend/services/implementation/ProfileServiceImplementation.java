package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.ProfileObject;
import com.netflix.backend.entities.Profile;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.ProfileRepository;
import com.netflix.backend.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImplementation implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public String deleteProfile(int profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile","profileId",""+profileId));
        profileRepository.delete(profile);
        return "Profile deleted successfully";
    }

    @Override
    public void addProfile(ProfileObject profile) {

    }
    private Profile profileObjectToProfile(ProfileObject profileObject ){
        Profile profile = new Profile();
        profile.setName(profileObject.getName());
        return profile;
    }
    private ProfileObject profileToProfileObject(Profile profile){
        ProfileObject profileObject = new ProfileObject();
        profileObject.setName(profile.getName());
        return profileObject;
    }
}
