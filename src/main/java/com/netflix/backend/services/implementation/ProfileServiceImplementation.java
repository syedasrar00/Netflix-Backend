package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.ProfileObject;
import com.netflix.backend.entities.Profile;
import com.netflix.backend.entities.User;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.ProfileRepository;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;


@Service
public class ProfileServiceImplementation implements ProfileService {
    @Autowired
    Cookie cookie;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public String deleteProfile(long profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile","profileId",""+profileId));
        profileRepository.delete(profile);
        return "Profile deleted successfully";
    }

    @Override
    public void addProfile(ProfileObject profileObject) {
        String username = cookie.getName();
        System.out.println(username);
        User user = userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User","UserName",username));
        Profile profile = profileObjectToProfile(profileObject);
        user.getProfiles().add(profile);
        profile.setUser(user);
        profileRepository.save(profile);

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
