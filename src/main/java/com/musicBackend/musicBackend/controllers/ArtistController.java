package com.musicBackend.musicBackend.controllers;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("getArtists")
    public String getArtist(Model model){
        model.addAttribute("getArtist",artistService.getArtist());
        return "artistHome";
    }

    @GetMapping("addArtist")
    public String registerNewArtist(Model model) {
        Artist artist = new Artist();
        model.addAttribute("artist",artist);
        return "newArtist";
    }

    @DeleteMapping(path = "/deleteArtist/{artistId}")
    public String deleteArtist(@PathVariable("artistId") Long artistId){
        artistService.deleteArtist(artistId);
        return "artistHome";
    }
}
