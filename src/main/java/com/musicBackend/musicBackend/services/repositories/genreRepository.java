package com.musicBackend.musicBackend.services.repositories;

import com.musicBackend.musicBackend.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface genreRepository extends JpaRepository<Genre, Long> {
    @Query("Select s FROM Genre s WHERE s.id = ?1")
    Optional<Genre> findGenreById(Long id);
}
