package com.musicBackend.musicBackend.controllers;


import com.musicBackend.musicBackend.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/genre")
public class GenreController {

    private final com.musicBackend.musicBackend.services.genreService genreService;
    @Autowired
    public GenreController(com.musicBackend.musicBackend.services.genreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping
    public List<Genre> getGenres(){

        return genreService.getGenre();
    }

    @PostMapping(path = "registerGenre")
    public void registerNewGenre(@RequestBody Genre Genre) {

        genreService.addNewGenre(Genre);
    }

    @DeleteMapping(path = "{GenreId}")
    public void deleteGenre(@PathVariable("GenreId") Long GenreId){

        genreService.deleteGenre(GenreId);
    }
}
