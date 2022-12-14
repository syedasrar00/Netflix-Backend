package com.netflix.backend.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

public class VideoObject {

    private long id;
    private String videoUrl;
    private int videoLength;
    private double rating;

    public VideoObject() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
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
