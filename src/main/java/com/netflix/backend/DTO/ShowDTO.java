package com.netflix.backend.DTO;


public class ShowDTO {
    private String showId;
    private String name;
    private String typeOfShow;
    private String genre;
    private String audience;
    private double rating;
    private int length;
    private String thumbnailLink;

    public ShowDTO() {
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
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
}
