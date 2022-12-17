package com.netflix.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String description;
    @OneToMany
    private List<Series> videos;
    private boolean isShowMovie = false;
    @OneToOne
    @JoinColumn(name = "video_id")
    private Video video;

    public Show() {}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Series> getVideos() {
        return videos;
    }

    public void setVideos(List<Series> videos) {
        this.videos = videos;
    }

    public boolean isShowMovie() {
        return isShowMovie;
    }

    public void setShowMovie(boolean showMovie) {
        isShowMovie = showMovie;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
