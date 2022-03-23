package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.MusicCollection;
import com.musicBackend.musicBackend.models.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class musicCollectionService {
    private final com.musicBackend.musicBackend.repositories.musicCollectionRepository musicCollectionRepository;

    private final com.musicBackend.musicBackend.services.playListService playListService;

    @Autowired
    public musicCollectionService(com.musicBackend.musicBackend.repositories.musicCollectionRepository musicCollectionRepository,
                                  com.musicBackend.musicBackend.services.playListService playListService) {
        this.musicCollectionRepository = musicCollectionRepository;
        this.playListService = playListService;
    }

    public void addMusicCollection (MusicCollection musicCollection){
        Optional<MusicCollection> musicCollectionOptional = musicCollectionRepository.findMusicCollectionById(musicCollection.getId());
        if (!musicCollectionOptional.isPresent()) {
            throw new IllegalStateException("Music collection is being used");
        }
        musicCollectionRepository.save(musicCollection);
        System.out.println(musicCollection);
    }

    public void deleteMusicCollection (Long musicCollectionId){
        boolean exists = musicCollectionRepository.existsById(musicCollectionId);
        if(!exists){
            throw new IllegalStateException("Music collection with id " + musicCollectionId + " does not exists.");
        }
        musicCollectionRepository.deleteById(musicCollectionId);
    }

    private MusicCollection getMusicCollection(Long musicCollectionId){
        Optional<MusicCollection> musicCollectionOptional = musicCollectionRepository.findMusicCollectionById(musicCollectionId);
        if (!musicCollectionOptional.isPresent()) {
            throw new IllegalStateException("Music collection doesn't exist");
        }
        return musicCollectionOptional.get();
    }

    public int countOfPlaylistsInCollection(Long musicCollectionId){
        MusicCollection musicCollection = getMusicCollection(musicCollectionId);
        return musicCollection.getPlayLists().size();
    }

    public Set<PlayList> displayPlayListInCollection(Long musicCollectionId){
        return getMusicCollection(musicCollectionId).getPlayLists();
    }
}
