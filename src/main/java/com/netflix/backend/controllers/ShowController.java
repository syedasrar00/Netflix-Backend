package com.netflix.backend.controllers;

import com.netflix.backend.DTO.ShowDTO;
import com.netflix.backend.services.ShowService;
import com.netflix.backend.entities.constants.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;
    @GetMapping("/show/{showId}")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<ShowDTO> getShowInfo(@PathVariable("showId") String showId){
        return new ResponseEntity<>(showService.getShowInfo(showId), HttpStatus.OK);
    }
    @GetMapping("/show")
    @Secured(UserRole.CUSTOMER)
    public ResponseEntity<List<ShowDTO>> getShowsByName(@RequestParam("showName") String showName){
        return new ResponseEntity<>(showService.getShowByName(showName), HttpStatus.OK);
    }
}
