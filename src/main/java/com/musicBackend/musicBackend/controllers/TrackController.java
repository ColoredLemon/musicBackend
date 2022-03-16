package com.musicBackend.musicBackend.controllers;


import com.musicBackend.musicBackend.models.Track;
import com.musicBackend.musicBackend.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "track")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
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
