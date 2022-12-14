package com.netflix.backend.services.implementation;

import com.netflix.backend.entities.User;
import com.netflix.backend.entities.Video;
import com.netflix.backend.entities.History;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.repositories.VideoRepository;
import com.netflix.backend.repositories.HistoryRepository;
import com.netflix.backend.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImplementation implements VideoService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private VideoRepository videoRepo;
    @Autowired
    private HistoryRepository watchHistoryRepository;
    @Autowired
    private Cookie cookie;
    @Override
    public String getVideoUrl(long id) {
        return videoRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Video","VideoId",id+"")).getVideoUrl();
    }

    @Override
    public void setRating(long id, double rating) {
        Video video = videoRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Video","VideoId",id+""));
        double newRating = (rating+video.getRating())/(video.getNoOfResponses()+1);
        video.setRating(newRating);
        video.setNoOfResponses(video.getNoOfResponses()+1);
        videoRepo.save(video);
    }

    @Override
    public void setWatchTime(long id, int timeInSeconds) {
        User user = userRepo.findByEmail(cookie.getName()).orElseThrow(()-> new ResourceNotFoundException("user","username",cookie.getName()));
        Video video = videoRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Video","VideoId",id+""));
        History watchHistory;
        try{
            watchHistory = watchHistoryRepository.findByUserAndVideo(video.getId(),user.getId()).orElseThrow( () -> new ArithmeticException());
        }catch(ArithmeticException ex){
            watchHistory = new History();
        }
        watchHistory.setDuration(timeInSeconds);
        watchHistory.setVideo(video);
        watchHistory.setUser(user);
        watchHistoryRepository.save(watchHistory);
    }

    @Override
    public int getWatchTime(long videoId) {
        User user = userRepo.findByEmail(cookie.getName()).orElseThrow(()-> new ResourceNotFoundException("user","username",cookie.getName()));
        Video video = videoRepo.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("Video","VideoId",videoId+""));
        History watchHistory = watchHistoryRepository.findByUserAndVideo(video.getId(),user.getId()).orElseGet(()-> new History());
        return watchHistory.getDuration();
    }
}
