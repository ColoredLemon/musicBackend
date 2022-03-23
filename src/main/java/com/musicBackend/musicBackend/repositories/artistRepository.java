package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.models.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface artistRepository extends JpaRepository<Artist, Long> {

    @Query("Select s FROM Artist s WHERE s.id = ?1")
    Optional<Artist> findArtistById(long id);
}
