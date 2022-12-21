package com.netflix.backend.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @Column(name="video_id",updatable = false, nullable = false)
    private String videoId;
    private String name;
    private int noOfResponses;
    private String videoPath;
    private String thumbnailPath;
    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private double rating;
    private int videoLength;
    private Date releaseDate;
    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<WatchHistory> watchHistories;

    public Video() {
    }

    public int getNoOfResponses() {
        return noOfResponses;
    }

    public void setNoOfResponses(int noOfResponses) {
        this.noOfResponses = noOfResponses;
    }

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

    public Series getSeries() {
        return series;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
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