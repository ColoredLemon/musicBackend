package com.musicBackend.musicBackend.controllers;

import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Track;
import com.musicBackend.musicBackend.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "track")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @GetMapping
    public String getTracks(Model model){
        model.addAttribute("getTracks",trackService.getTracks());
        return "UserLibrary";
    }

    @PostMapping(path = "registerTrack")
    public String registerNewTrack(Model model) {
        Track track = new Track();
        model.addAttribute("track",track);
        return "UserLibrary";
    }

    @DeleteMapping(path = "/deleteTrack/{TrackId}")
    public String deleteTrack(@PathVariable("TrackId") Long TrackId){
        trackService.deleteTrack(TrackId);
        return "UserLibrary";
    }
}
