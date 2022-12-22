package com.netflix.backend.controllers;

import com.netflix.backend.DTO.WatchHistoryDTO;
import com.netflix.backend.services.WatchHistoryService;
import com.netflix.backend.entities.constants.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
public class WatchHistoryController {
    @Autowired
    WatchHistoryService watchHistoryService;
    @PostMapping("/video/{videoId}/watchTime")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<?> updateWatchHistory(@RequestBody WatchHistoryDTO watchTime,
                                                   @PathVariable String videoId){
        watchHistoryService.setWatchHistory(watchTime,videoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/video/{videoId}/profile/{profileId}/watchTime")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<Integer> getWatchHistory(@PathVariable String videoId, @PathVariable String profileId){
        int watchTime = watchHistoryService.getWatchHistory(videoId, profileId);
        return ResponseEntity.status(HttpStatus.OK).body(watchTime);
    }
}

