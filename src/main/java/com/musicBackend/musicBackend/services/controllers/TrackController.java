package com.musicBackend.musicBackend.services.controllers;


import com.musicBackend.musicBackend.models.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/track")
public class TrackController {

    private final com.musicBackend.musicBackend.services.trackService trackService;

    @Autowired
    public TrackController(com.musicBackend.musicBackend.services.trackService trackService) {
        this.trackService = trackService;
    }
    @GetMapping
    public List<Track> getTracks(){

        return trackService.getTracks();
    }

    @PostMapping(path = "registerTrack")
    public void registerNewTrack(@RequestBody Track Track) {

        trackService.addNewTrack(Track);
    }

    @DeleteMapping(path = "{TrackId}")
    public void deleteTrack(@PathVariable("TrackId") Long TrackId){

        trackService.deleteTrack(TrackId);
    }
}
