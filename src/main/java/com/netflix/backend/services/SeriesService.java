package com.netflix.backend.services;

import com.netflix.backend.DTO.SeriesDTO;

public interface SeriesService {
    SeriesDTO getSeriesInfo(String seriesId);
}
