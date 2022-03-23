package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class genreService {
    private final com.musicBackend.musicBackend.repositories.genreRepository genreRepository;

    @Autowired
    public genreService(com.musicBackend.musicBackend.repositories.genreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public List<Genre> getGenres() {

        return genreRepository.findAll();
    }

    public Genre getGenre(long id) {
       Genre genre =genreRepository.findGenreById(id).orElse(null);
        return genre;
     }
    
    public void addNewGenre(Genre Genre) {
        Optional<Genre> GenreOptional = genreRepository.findGenreById(Genre.getId());
        if (GenreOptional.isPresent()) {
            throw new IllegalStateException("email is being used");
        }
        genreRepository.save(Genre);
        System.out.println(Genre);
    }

    public void deleteGenre(Long GenreId) {
        boolean exists = genreRepository.existsById(GenreId);
        if(!exists){
            throw new IllegalStateException("Genre with id " + GenreId + " does not exists.");
        }
        genreRepository.deleteById((GenreId));
    }
}
