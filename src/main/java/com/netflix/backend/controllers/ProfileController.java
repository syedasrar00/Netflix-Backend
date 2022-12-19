package com.netflix.backend.controllers;

import com.netflix.backend.DTO.ProfileDTO;
import com.netflix.backend.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @PostMapping("/user/profile")
    public ResponseEntity<?> createProfile(@Valid @RequestBody ProfileDTO profileDTO){
        profileService.addProfile(profileDTO);
        return ResponseEntity.ok("");
    }
    @DeleteMapping("user/profile/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable String profileId){
        profileService.deleteProfile(profileId);
        return ResponseEntity.ok("Profile deleted successfully");
    }
}
