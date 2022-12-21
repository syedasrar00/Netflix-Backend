package com.netflix.backend.entities;

import javax.persistence.*;
import java.util.List;
@Entity
public class Series {
    @Id
    @Column(name = "series_id", updatable = false, nullable = false)
    private String seriesId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private int numberOfVideos;
    private double rating;
    private int totalLength;
    private String thumbnailPath;
    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
    private List<Video> videos;

    public Series() {
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }

    public void setNumberOfVideos(int numberOfVideos) {
        this.numberOfVideos = numberOfVideos;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
