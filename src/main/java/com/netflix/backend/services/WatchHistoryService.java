package com.netflix.backend.services;


import com.netflix.backend.DTO.WatchHistoryDTO;

public interface WatchHistoryService {
    void setWatchHistory(WatchHistoryDTO watchTime, String videoId);
    int getWatchHistory(String videoId, String profileId);
}
