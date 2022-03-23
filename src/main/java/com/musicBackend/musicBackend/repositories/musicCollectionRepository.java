package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.MusicCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface musicCollectionRepository extends JpaRepository<MusicCollection, Long> {
    @Query("Select m FROM MusicCollection m WHERE m.id = ?1")
    Optional<MusicCollection> findMusicCollectionById(Long id);
}
