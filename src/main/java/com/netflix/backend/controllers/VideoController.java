package com.netflix.backend.controllers;

import com.netflix.backend.services.VideoService;
import com.netflix.backend.entities.constants.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping("/video/{videoId}/link")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<?> getVideoUrl(@PathVariable String videoId){
        return ResponseEntity.ok(videoService.getVideoUrl(videoId));
    }
    @GetMapping("/video/{videoId}/thumbnail")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<?> getVideoThumbnailUrl(@PathVariable String videoId){
        return ResponseEntity.ok(videoService.getVideoThumbnailUrl(videoId));
    }
    @PostMapping("/video/{videoId}/rating")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<?> setRating(@PathVariable String videoId,@RequestParam("rating") double rating){
        videoService.setRating(videoId,rating);
        return ResponseEntity.ok("");
    }
}
