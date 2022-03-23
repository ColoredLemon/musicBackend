package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class playListService {

    private final com.musicBackend.musicBackend.repositories.playListRepository playListRepository;
    private final trackService trackService;
    @Autowired
    public playListService(com.musicBackend.musicBackend.repositories.playListRepository playListRepository, trackService trackService) {
        this.playListRepository = playListRepository;
        this.trackService = trackService;
    }

    private PlayList getPlayList(Long playListId){
        Optional<PlayList> playListOptional = playListRepository.findPlayListById(playListId);
        if (!playListOptional.isPresent()) {
            throw new IllegalStateException("PlayList doesn't exist");
        }
        return playListOptional.get();
    }

    public void addSongToPlayList(Long playListId, Long trackId){
        PlayList playList = getPlayList(playListId);
        playList.getTracks().add(trackService.getTrackById(trackId));
    }

    public void removeSongFormPlaylist (Long playListId, Long trackId){
        PlayList playList = getPlayList(playListId);
        playList.getTracks().remove(trackService.getTrackById(trackId));
    }

    public void addPlayList (PlayList playList){
        Optional<PlayList> playListOptional = playListRepository.findPlayListById(playList.getId());
        if (!playListOptional.isPresent()) {
            throw new IllegalStateException("PlayList is being used");
        }
        playListRepository.save(playList);
        System.out.println(playList);
    }

    public void deletePlayList (Long playListId){
        boolean exists = playListRepository.existsById(playListId);
        if(!exists){
            throw new IllegalStateException("Playlist with id " + playListId + " does not exists.");
        }
        playListRepository.deleteById(playListId);
    }

    public int countsOfSongsInPlayList (Long playListId){
        PlayList playList = getPlayList(playListId);
        return playList.getTracks().size();
    }
}
