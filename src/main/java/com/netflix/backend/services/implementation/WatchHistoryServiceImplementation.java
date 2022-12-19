package com.netflix.backend.services.implementation;

import com.netflix.backend.entities.Profile;
import com.netflix.backend.entities.Video;
import com.netflix.backend.entities.WatchHistory;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.ProfileRepository;
import com.netflix.backend.repositories.VideoRepository;
import com.netflix.backend.repositories.WatchHistoryRepository;
import com.netflix.backend.services.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class WatchHistoryServiceImplementation implements WatchHistoryService {
    @Autowired
    private WatchHistoryRepository watchHistoryRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public void setWatchHistory(String videoId, int watchTime, String profileId) {
        Video video =  videoRepository.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        Profile profile = profileRepository.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile"));
        WatchHistory watchHistory = watchHistoryRepository.findByVideo(video).orElseGet(()->{
            WatchHistory history = new WatchHistory();
            history.setVideo(video);
            history.setFirstWatchedAt(new Date(System.currentTimeMillis()));
            history.setProfile(profile);
            return history;
        });
        watchHistory.setLastWatchedAt(new Date(System.currentTimeMillis()));
        watchHistory.setWatchedLength(watchTime);
    }

    @Override
    public int getWatchHistory(String videoId) {
        Video video =  videoRepository.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        WatchHistory w = watchHistoryRepository.findByVideo(video).orElseThrow(()-> new ResourceNotFoundException("Watch History"));
        return w.getWatchedLength();
    }
}
