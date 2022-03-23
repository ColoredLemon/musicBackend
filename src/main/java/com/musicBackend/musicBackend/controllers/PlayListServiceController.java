package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.services.playListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/playList")
public class PlayListServiceController {
    private final playListService playListService;

    @Autowired
    public PlayListServiceController(playListService playListService){
        this.playListService = playListService;
    }

    @PostMapping
    public void addMusicCollection(@RequestBody PlayList playList) {
        playListService.addPlayList(playList);
    }

    @DeleteMapping(path = "{playListId}")
    public void deletePermission(@PathVariable("playListId") Long playListId){
        playListService.deletePlayList(playListId);
    }

    @GetMapping("/addSongToPlayList")
    public void addSongToPlayList(@RequestParam(name="playListId") long playListId, @RequestParam(name="trackId") long trackId) {
        playListService.addSongToPlayList(playListId, trackId);
    }

    @GetMapping("/removeSongFormPlaylist")
    public void removeSongFormPlaylist(@RequestParam(name="playListId") long playListId, @RequestParam(name="trackId") long trackId) {
        playListService.removeSongFormPlaylist(playListId, trackId);
    }

    @GetMapping("/countsOfSongsInPlayList")
    public Integer countsOfSongsInPlayList(@RequestParam(name="playListId") long playListId) {
        return playListService.countsOfSongsInPlayList(playListId);
    }

}
