package com.netflix.backend.services;

import com.netflix.backend.entities.Show;

import java.util.List;

public interface ShowService {
    Show getShowInfo(long id);
    List<Show> getShowByName(String name);
}
