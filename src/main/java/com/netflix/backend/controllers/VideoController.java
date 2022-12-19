package com.netflix.backend.controllers;

import com.netflix.backend.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping("/video/{videoId}/link")
    public ResponseEntity<?> getVideoUrl(@PathVariable String videoId){
        return ResponseEntity.ok(videoService.getVideoUrl(videoId));
    }
    @PostMapping("/video/{videoId}/rating")
    public ResponseEntity<?> setRating(@PathVariable String videoId,@RequestParam("rating") double rating){
        videoService.setRating(videoId,rating);
        return ResponseEntity.ok("");
    }
}
