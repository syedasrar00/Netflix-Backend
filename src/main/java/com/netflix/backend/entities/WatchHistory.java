package com.netflix.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WatchHistory {
    @Id
    @Column(name = "watch_history_id", updatable = false, nullable = false)
    private String watchHistoryId;
    private int watchedLength;
    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    private Double rating;
    private Date firstWatchedAt;
    private Date lastWatchedAt;

    public WatchHistory() {
    }

    public String getWatchHistoryId() {
        return watchHistoryId;
    }

    public void setWatchHistoryId(String watchHistoryId) {
        this.watchHistoryId = watchHistoryId;
    }

    public int getWatchedLength() {
        return watchedLength;
    }

    public void setWatchedLength(int watchedLength) {
        this.watchedLength = watchedLength;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getFirstWatchedAt() {
        return firstWatchedAt;
    }

    public void setFirstWatchedAt(Date firstWatchedAt) {
        this.firstWatchedAt = firstWatchedAt;
    }

    public Date getLastWatchedAt() {
        return lastWatchedAt;
    }

    public void setLastWatchedAt(Date lastWatchedAt) {
        this.lastWatchedAt = lastWatchedAt;
    }
}