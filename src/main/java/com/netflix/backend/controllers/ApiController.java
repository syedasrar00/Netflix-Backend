package com.netflix.backend.controllers;

import com.netflix.backend.entities.Video;
import com.netflix.backend.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ApiController {
    @Autowired
    private VideoRepository videoRepository;
    @PostMapping("/video/upload")
    public ResponseEntity<Video> upload(@RequestBody Video video){
        return ResponseEntity.ok(videoRepository.save(video));
    }
    @GetMapping("/video/download")
    public ResponseEntity<Video> download(@RequestParam long id){
        return ResponseEntity.ok(videoRepository.findById(id).orElseThrow());
    }
}
