package com.netflix.backend.DTO;

public class WatchHistoryDTO {
    private int watchTime;
    private String profileId;

    public WatchHistoryDTO() {
    }

    public int getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(int watchTime) {
        this.watchTime = watchTime;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
}
