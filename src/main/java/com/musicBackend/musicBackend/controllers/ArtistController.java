package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/artist")
public class ArtistController {

    private final com.musicBackend.musicBackend.services.artistService artistService;

    @Autowired
    public ArtistController(com.musicBackend.musicBackend.services.artistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping//("getArtists")
    public List<Artist> getArtist(){

        return artistService.getArtist();
    }

    @PostMapping("addArtist")
    public void registerNewArtist(@RequestBody Artist artist) {

        artistService.addNewArtist(artist);
    }

    @DeleteMapping(path = "{artistId}")
    public void deleteArtist(@PathVariable("artistId") Long artistId){

        artistService.deleteArtist(artistId);
    }
}
