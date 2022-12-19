package com.netflix.backend.services;


public interface WatchHistoryService {
    void setWatchHistory(String videoId, int watchTime, String profileId);
    int getWatchHistory(String videoId);
}
