package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.ProfileDTO;
import com.netflix.backend.entities.constants.ProfileType;
import com.netflix.backend.entities.Profile;
import com.netflix.backend.entities.User;
import com.netflix.backend.exceptions.InvalidCredentialsException;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.ProfileRepository;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


@Service
public class ProfileServiceImplementation implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String deleteProfile(String profileId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
            Profile profile = profileRepository.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile"));
        if(profile.getUser().getUserId().equals(user.getUserId())){

            profileRepository.delete(profile);
            return "Profile deleted successfully";
        }
        throw new InvalidCredentialsException("profile not linked with current user");
    }

    @Override
    public void addProfile(ProfileDTO profileDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        profile.setProfileId(UUID.randomUUID().toString());
        profile.setProfileType(ProfileType.GENERAL);
        profile.setUser(user);
        profile.setCreatedAt(new Date());
        user.getProfiles().add(profile);
        userRepository.save(user);
    }
}
