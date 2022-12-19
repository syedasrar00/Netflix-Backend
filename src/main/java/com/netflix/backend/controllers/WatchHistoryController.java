package com.netflix.backend.controllers;

import com.netflix.backend.services.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class WatchHistoryController {
    @Autowired
    WatchHistoryService watchHistoryService;
    @PostMapping("/video/{videoId}/watchTime")
    public ResponseEntity<Void> updateWatchHistory(@RequestParam int watchTime,
                                                   @RequestParam String profileId,
                                                   @PathVariable String videoId){
        watchHistoryService.setWatchHistory(videoId,watchTime,profileId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/video/{videoId}/watchTime")
    public ResponseEntity<Integer> getWatchHistory(@PathVariable String videoId){
        int watchTime = watchHistoryService.getWatchHistory(videoId);
        return ResponseEntity.status(HttpStatus.OK).body(watchTime);
    }
}
