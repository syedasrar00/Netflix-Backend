package com.netflix.backend.entities;

import com.netflix.backend.ENUMS.Audience;
import com.netflix.backend.ENUMS.Genre;
import com.netflix.backend.ENUMS.TypeOfShow;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @Column(name = "show_id", updatable = false, nullable = false)
    private String showId;
    private String name;
    @Enumerated
    private TypeOfShow typeOfShow;
    @Enumerated
    private Genre genre;
    @Enumerated
    private Audience audience;
    private double rating;
    private int length;
    @OneToMany(mappedBy = "show")
    private List<Video> videos;
    @OneToMany(mappedBy = "show")
    private List<Series> series;

    public Show() {
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

    public TypeOfShow getTypeOfShow() {
        return typeOfShow;
    }

    public void setTypeOfShow(TypeOfShow typeOfShow) {
        this.typeOfShow = typeOfShow;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
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