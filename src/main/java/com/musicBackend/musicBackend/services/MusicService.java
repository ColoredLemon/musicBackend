package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.Music;
import com.musicBackend.musicBackend.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }
    public List<Music> getMusic() {
        return musicRepository.findAll();
    }

    public void addNewMusic(Music music) {
        Optional<Music> musicOptional = musicRepository.findMusicById(music.getId());
        if (musicOptional.isPresent()) {
            throw new IllegalStateException("email is being used");
        }
        musicRepository.save(music);
        System.out.println(music);
    }

    public void deleteMusic(Long musicId) {
        boolean exists = musicRepository.existsById(musicId);
        if(!exists){
            throw new IllegalStateException("music with id " + musicId + " does not exists.");
        }
        musicRepository.deleteById((musicId));
    }
}
