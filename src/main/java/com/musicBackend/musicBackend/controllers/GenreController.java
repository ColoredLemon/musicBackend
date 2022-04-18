package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Member;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Genre;
import com.musicBackend.musicBackend.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "genre")
public class GenreController {

    private final GenreService genreService;
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping
    public String getGenres(Model model){

        model.addAttribute("genre",genreService.getGenre());
        return "genre";
    }

    @GetMapping(path = "/registerGenre")
    public String registerNewGenre(Model model) {
        Genre genre = new Genre();
        model.addAttribute("genre",genre);
        return "newGenre";
    }
    @PostMapping("/saveGenre")
    public String saveEmployee(@ModelAttribute("genre") Genre genre) {
        genreService.addNewGenre(genre);
        return "redirect:/";
    }

    @DeleteMapping(path = "/deleteGenre/{GenreId}")
    public String deleteGenre(@PathVariable("GenreId") Long GenreId){
        genreService.deleteGenre(GenreId);
        return "genre";
    }
}
