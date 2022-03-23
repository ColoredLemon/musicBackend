package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.models.Music;
import com.musicBackend.musicBackend.repositories.artistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class artistService {

    private final artistRepository artistRepository;

    @Autowired
    public artistService(com.musicBackend.musicBackend.repositories.artistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }
    
    public Artist getArtist(Long id) {
        Artist artist =artistRepository.findArtistById(id).orElse(null);
        return artist;
     }
    
    public void addNewArtist(Artist artist) {
        Optional<Artist> artistOptional = artistRepository.findArtistById(artist.getId());
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
