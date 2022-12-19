package com.netflix.backend.services.implementation;

import com.netflix.backend.entities.Show;
import com.netflix.backend.services.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowServiceImplementation implements ShowService {
    @Override
    public Show getShowInfo(String id) {
        return null;
    }

    @Override
    public List<Show> getShowByName(String name) {
        return null;
    }
}
