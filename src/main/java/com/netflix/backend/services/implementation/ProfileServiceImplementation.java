package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.ProfileDTO;
import com.netflix.backend.ENUMS.ProfileType;
import com.netflix.backend.entities.Profile;
import com.netflix.backend.entities.User;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.ProfileRepository;
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
    private ModelMapper modelMapper;
    @Override
    public String deleteProfile(String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile"));
        profileRepository.delete(profile);
        return "Profile deleted successfully";
    }

    @Override
    public void addProfile(ProfileDTO profileDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        profile.setId(UUID.randomUUID().toString());
        profile.setProfileType(ProfileType.GENERAL);
        profile.setUser(user);
        profile.setCreatedAt(new Date());
        user.getProfiles().add(profile);
        profileRepository.save(profile);
    }
}
