package com.musicBackend.musicBackend.controllers;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
@Controller
@RequestMapping(path = "/playList")
public class PlayListServiceController {
    private final PlayListService playListService;

    @Autowired
    public PlayListServiceController(PlayListService playListService){
        this.playListService = playListService;
    }

    @PostMapping
    public String addMusicCollection(Model model) {
        PlayList playList = new PlayList();
        model.addAttribute("playlist",playList);
        playListService.addPlayList(playList);
        //In the "return" section, it is returning to the html page that you specify
        //The html page you specify must be placed under the resources/templates folder
        return "playListHome";
    }

    @DeleteMapping(path = "/deletePlayList/{playListId}")
    public String deletePermission(@PathVariable("playListId") Long playListId){
        playListService.deletePlayList(playListId);
        return "playList";
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