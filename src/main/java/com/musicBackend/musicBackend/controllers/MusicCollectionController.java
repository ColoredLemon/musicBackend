package com.musicBackend.musicBackend.controllers;

import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.MusicCollection;
import com.musicBackend.musicBackend.models.PlayList;
import com.musicBackend.musicBackend.services.MusicCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@RequestMapping(path = "/musicCollection")
public class MusicCollectionController {
    private final MusicCollectionService musicCollectionService;

    @Autowired
    public MusicCollectionController(MusicCollectionService musicCollectionService){
        this.musicCollectionService = musicCollectionService;
    }

    @PostMapping
    public String addMusicCollection(Model model) {
        MusicCollection musicCollection = new MusicCollection();
        model.addAttribute("musicCollection", musicCollection);
        musicCollectionService.addMusicCollection(musicCollection);
        //In the "return" section, it is returning to the html page that you specify
        //The html page you specify must be placed under the resources/templates folder
        return "musicCollectionHome";
    }

    @DeleteMapping(path = "{musicCollectionId}")
    public String deletePermission(@PathVariable("musicCollectionId") Long musicCollectionId){
        musicCollectionService.deleteMusicCollection(musicCollectionId);
        return "musicCollectionHome";
    }

    @GetMapping("/countOfPlaylistsInCollection")
    public String countOfPlaylistsInCollection(@RequestParam(name="musicCollectionId") long musicCollectionId, Model model) {
        int Count = musicCollectionService.countOfPlaylistsInCollection(musicCollectionId);
        String collectionCount = Integer.toString(Count);
        model.addAttribute("countOfCollection",collectionCount);
        return "musicCollectionHome";
    }

    @GetMapping("/displayPlayListInCollection")
    public String displayPlayListInCollection(@RequestParam(name="musicCollectionId") long musicCollectionId, Model model) {
        model.addAttribute("musicCollectionList",musicCollectionService.displayPlayListInCollection(musicCollectionId));
        return "musicCollectionHome";
    }
}