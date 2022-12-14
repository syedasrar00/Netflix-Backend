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
    public ResponseEntity<?> getVideoUrl(@PathVariable long videoId){
        return ResponseEntity.ok(videoService.getVideoUrl(videoId));
    }
    @PostMapping("/video/{videoId}/rating")
    public ResponseEntity<?> setRating(@PathVariable long videoId,@RequestParam("rating") double rating){
        videoService.setRating(videoId,rating);
        return ResponseEntity.ok("");
    }
    @PostMapping("/video/{videoId}/watchTime")
    public ResponseEntity<?> setWatchTime(@PathVariable long videoId, @RequestParam("watchTime") int watchTime){
        videoService.setWatchTime(videoId,watchTime);
        return ResponseEntity.ok("");
    }
    @GetMapping("/video/{videoId}/watchTime")
    public ResponseEntity<?> getWatchTime(@PathVariable long videoId){
        return ResponseEntity.ok(videoService.getWatchTime(videoId));
    }
}
