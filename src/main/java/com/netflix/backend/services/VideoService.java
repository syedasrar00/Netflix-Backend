package com.netflix.backend.services;

import java.util.UUID;

public interface VideoService {
    String getVideoUrl(long id);
    void setRating(long id, double rating);
    void setWatchTime(long id, int timeInSeconds);
    int getWatchTime(long videoId);
}
