package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    @Query("Select p FROM PlayList p WHERE p.id = ?1")
    Optional<PlayList> findPlayListById(Long id);
}