package com.netflix.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @Column(name = "show_id", updatable = false, nullable = false)
    private String showId;
    private String name;
    private String typeOfShow;

    private String genre;

    private String audience;
    private double rating;
    private int length;
    private String thumbnailPath;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Video> videos;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Series> series;

    public Show() {
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfShow() {
        return typeOfShow;
    }

    public void setTypeOfShow(String typeOfShow) {
        this.typeOfShow = typeOfShow;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}