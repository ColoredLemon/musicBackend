package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/music")
public class MusicController {

    private final com.musicBackend.musicBackend.services.musicService musicService;
    @Autowired
    public MusicController(com.musicBackend.musicBackend.services.musicService musicService) {
        this.musicService = musicService;
    }
    @GetMapping
    public List<Music> getMusics(){

        return musicService.getMusic();
    }

    @PostMapping(path = "registermusic")
    public void registerNewMusic(@RequestBody Music music) {

        musicService.addNewMusic(music);
    }

    @DeleteMapping(path = "{musicId}")
    public void deleteMusic(@PathVariable("musicId") Long musicId){

        musicService.deleteMusic(musicId);
    }
}
