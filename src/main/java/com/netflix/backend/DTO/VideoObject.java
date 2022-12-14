package com.netflix.backend.DTO;

import com.netflix.backend.entities.UserVideoHistory;

import java.util.UUID;

public class VideoObject {
    private UUID id;
    private String videoUrl;
    private int videoLength;
    private double rating;

    private UserVideoHistory userVideoHistory;

    public VideoObject() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public UserVideoHistory getUserVideoHistory() {
        return userVideoHistory;
    }

    public void setUserVideoHistory(UserVideoHistory userVideoHistory) {
        this.userVideoHistory = userVideoHistory;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(int videoLength) {
        this.videoLength = videoLength;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
