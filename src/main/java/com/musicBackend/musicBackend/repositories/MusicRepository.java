package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {

    @Query("Select s FROM Music s WHERE s.id = ?1")
    Optional<Music> findMusicById(Long id);
}
