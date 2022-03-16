package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Music;
import com.musicBackend.musicBackend.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "music")
public class MusicController {

    private final MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }
    @GetMapping
    public List<Music> getMusics(){

        return musicService.getMusic();
    }

    @PostMapping(path = "registerMusic")
    public void registerNewMusic(@RequestBody Music music) {

        musicService.addNewMusic(music);
    }

    @DeleteMapping(path = "{musicId}")
    public void deleteMusic(@PathVariable("musicId") Long musicId){

        musicService.deleteMusic(musicId);
    }
}
