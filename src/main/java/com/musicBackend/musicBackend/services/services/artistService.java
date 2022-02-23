package com.musicBackend.musicBackend.services.services;

import com.musicBackend.musicBackend.services.models.Artist;
import com.musicBackend.musicBackend.services.repositories.artistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class artistService {

    private final com.musicBackend.musicBackend.services.repositories.artistRepository artistRepository;

    @Autowired
    public artistService(com.musicBackend.musicBackend.services.repositories.artistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtist() {
        return artistRepository.findAll();
    }

    public void addNewArtist(Artist artist) {
        Optional<Artist> artistOptional = artistRepository.findArtistByEmail(artist.getArtistEmail());
        if (artistOptional.isPresent()) {
            throw new IllegalStateException("email is being used");
        }
        artistRepository.save(artist);
        System.out.println(artist);
    }

    public void deleteArtist(Long artistId) {
        boolean exists = artistRepository.existsById(artistId);
        if(!exists){
            throw new IllegalStateException("Artist with id " + artistId + " does not exists.");
        }
        artistRepository.deleteById((artistId));
    }
}