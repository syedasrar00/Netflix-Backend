package com.netflix.backend.DTO;


import com.netflix.backend.entities.WatchHistory;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class VideoDTO {
    private String videoId;
    private String name;
    private String videoPath;
    private String Series;
    private String Show;
    private double rating;
    private int videoLength;
    private Date releaseDate;
    @OneToMany(mappedBy = "video")
    private List<WatchHistory> watchHistories;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getSeries() {
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public String getShow() {
        return Show;
    }

    public void setShow(String show) {
        Show = show;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(int videoLength) {
        this.videoLength = videoLength;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<WatchHistory> getWatchHistories() {
        return watchHistories;
    }

    public void setWatchHistories(List<WatchHistory> watchHistories) {
        this.watchHistories = watchHistories;
    }
}