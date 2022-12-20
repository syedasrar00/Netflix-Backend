package com.netflix.backend.services;

import com.netflix.backend.DTO.ShowDTO;

import java.util.List;

public interface ShowService {
    ShowDTO getShowInfo(String showId);
    List<ShowDTO> getShowByName(String name);
}
