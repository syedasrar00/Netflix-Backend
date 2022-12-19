package com.netflix.backend.services;

import com.netflix.backend.entities.Show;

import java.util.List;

public interface ShowService {
    Show getShowInfo(String id);
    List<Show> getShowByName(String name);
}
