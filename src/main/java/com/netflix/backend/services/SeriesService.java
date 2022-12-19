package com.netflix.backend.services;

import com.netflix.backend.entities.Series;

public interface SeriesService {
    Series getSeriesInfo(String id);
}
