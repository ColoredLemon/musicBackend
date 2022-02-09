package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface listenerRepository extends JpaRepository<Listener, Long> {
    @Query("Select s FROM Listener s WHERE s.email = ?1")
    Optional<Listener> findListenerByEmail(String email);
}
