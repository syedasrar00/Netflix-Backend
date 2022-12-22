package com.netflix.backend.controllers;

import com.netflix.backend.DTO.SeriesDTO;
import com.netflix.backend.services.SeriesService;
import com.netflix.backend.entities.constants.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesController {
    @Autowired
    private SeriesService seriesService;
    @GetMapping("/series/{seriesId}")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<SeriesDTO> getSeriesInfo(@PathVariable String seriesId){
        return new ResponseEntity<>(seriesService.getSeriesInfo(seriesId), HttpStatus.OK);
    }
}
