package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
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
