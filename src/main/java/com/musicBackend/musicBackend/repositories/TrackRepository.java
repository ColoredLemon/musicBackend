package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {
    @Query("Select s FROM Track s WHERE s.id = ?1")
    Optional<Track> findTrackById(Long id);
}
