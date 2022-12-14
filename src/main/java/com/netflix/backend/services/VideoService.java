package com.netflix.backend.services;

import java.util.Date;
import java.util.UUID;

public interface VideoService {
    String getVideoUrl(UUID id);
    void setRating(UUID id, double rating);
    void setWatchTime(UUID id, int timeInSeconds);
    int getWatchTime();
}
