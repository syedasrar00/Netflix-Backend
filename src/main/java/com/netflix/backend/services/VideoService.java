package com.netflix.backend.services;

import java.util.UUID;

public interface VideoService {
    String getVideoUrl(String id);
    void setRating(String id, double rating);
}
