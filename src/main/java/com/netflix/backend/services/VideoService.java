package com.netflix.backend.services;


public interface VideoService {
    String getVideoUrl(String videoId);
    String getVideoThumbnailUrl(String videoId);
    void setRating(String videoId, double rating);
}
