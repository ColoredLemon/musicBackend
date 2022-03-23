package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.MusicCollection;
import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.services.musicCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/musicCollection")
public class MusicCollectionController {
    private final musicCollectionService musicCollectionService;

    @Autowired
    public MusicCollectionController(musicCollectionService musicCollectionService){
        this.musicCollectionService = musicCollectionService;
    }

    @PostMapping
    public void addMusicCollection(@RequestBody MusicCollection musicCollection) {
        musicCollectionService.addMusicCollection(musicCollection);
    }

    @DeleteMapping(path = "{musicCollectionId}")
    public void deletePermission(@PathVariable("musicCollectionId") Long musicCollectionId){
        musicCollectionService.deleteMusicCollection(musicCollectionId);
    }

    @GetMapping("/countOfPlaylistsInCollection")
    public Integer countOfPlaylistsInCollection(@RequestParam(name="musicCollectionId") long musicCollectionId) {
        return musicCollectionService.countOfPlaylistsInCollection(musicCollectionId);
    }

    @GetMapping("/displayPlayListInCollection")
    public Set<PlayList> displayPlayListInCollection(@RequestParam(name="musicCollectionId") long musicCollectionId) {
        return musicCollectionService.displayPlayListInCollection(musicCollectionId);
    }
}
