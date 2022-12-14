package com.netflix.backend.services.implementation;

import com.netflix.backend.repositories.UserVideoHistoryRepository;
import com.netflix.backend.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class VideoServiceImplementation implements VideoService {
    @Autowired
    private UserVideoHistoryRepository userVideoHistoryRepository;
    @Autowired
    private Cookie cookie;
    @Override
    public String getVideoUrl(UUID id) {

        return null;
    }

    @Override
    public void setRating(UUID id, double rating) {

    }

    @Override
    public void setWatchTime(UUID id, int timeInSeconds) {

    }

    @Override
    public int getWatchTime() {
        return 0;
    }
}
