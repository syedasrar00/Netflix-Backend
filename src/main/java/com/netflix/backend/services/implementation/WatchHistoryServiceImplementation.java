package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.WatchHistoryDTO;
import com.netflix.backend.entities.Profile;
import com.netflix.backend.entities.User;
import com.netflix.backend.entities.Video;
import com.netflix.backend.entities.WatchHistory;
import com.netflix.backend.exceptions.InvalidCredentialsException;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.ProfileRepository;
import com.netflix.backend.repositories.VideoRepository;
import com.netflix.backend.repositories.WatchHistoryRepository;
import com.netflix.backend.services.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@Service
public class WatchHistoryServiceImplementation implements WatchHistoryService {
    @Autowired
    private WatchHistoryRepository watchHistoryRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public void setWatchHistory(WatchHistoryDTO watchTime, String videoId) {
        Video video =  videoRepository.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        if(watchTime.getWatchTime()>video.getVideoLength()*60 || watchTime.getWatchTime()<0)
            throw new InvalidCredentialsException("Not a valid watchtime");
        Profile profile = profileRepository.findById(watchTime.getProfileId()).orElseThrow(()-> new ResourceNotFoundException("Profile"));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(profile.getUser().getUserId().equals(user.getUserId())) {
            WatchHistory watchHistory = null;
            try{
                watchHistory = watchHistoryRepository.findByVideoIdProfileId(video.getVideoId(),profile.getProfileId());
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            if(watchHistory == null){
                watchHistory = new WatchHistory();
                watchHistory.setWatchHistoryId(UUID.randomUUID().toString());
                watchHistory.setFirstWatchedAt(new Date());
                watchHistory.setVideo(video);
                watchHistory.setProfile(profile);
                watchHistory.setRating(video.getRating());
                watchHistory.setLastWatchedAt(new Date());
                watchHistory.setWatchedLength(watchTime.getWatchTime());
                watchHistoryRepository.save(watchHistory);
                return;
            }else{
                watchHistory.setLastWatchedAt(new Date());
                watchHistory.setWatchedLength(watchTime.getWatchTime());
                watchHistoryRepository.save(watchHistory);
            }
        }
        else
            throw new InvalidCredentialsException("Invalid profileId");
    }

    @Override
    public int getWatchHistory(String videoId) {
        Video video =  videoRepository.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video"));
        WatchHistory w = watchHistoryRepository.findByVideo(video).orElseThrow(()-> new ResourceNotFoundException("Watch History"));
        return w.getWatchedLength();
    }
}
