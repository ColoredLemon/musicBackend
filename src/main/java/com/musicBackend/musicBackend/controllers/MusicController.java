package com.musicBackend.musicBackend.controllers;
import com.musicBackend.musicBackend.models.Member;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Music;
import com.musicBackend.musicBackend.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "music")
public class MusicController {

    private final MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }
    @GetMapping
    public String getMusics(Model model){
        model.addAttribute("musicList",musicService.getMusic());
        //In the "return" section, it is returning to the html page that you specify
        //The html page you specify must be placed under the resources/templates folder
        return "musicHome";
    }

    @GetMapping(path = "registerMusic")
    public String registerNewMusic(Model model) {
        Music music = new Music();
        model.addAttribute("addMusic", music);
        return "musicHome";
    }
    @PostMapping("/saveMusuic")
    public String saveEmployee(@ModelAttribute("music") Music music) {
        musicService.addNewMusic(music);
        return "musicHome";
    }

    @DeleteMapping(path = "/deleteMusic/{musicId}")
    public String deleteMusic(@PathVariable("musicId") Long musicId){
        musicService.deleteMusic(musicId);
        return "musicHome";
    }
}
