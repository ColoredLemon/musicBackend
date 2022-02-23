package com.musicBackend.musicBackend.services.repositories;

import com.musicBackend.musicBackend.security.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface loginRepository extends JpaRepository<Login, Long> {
    @Query("Select s FROM Login s WHERE s.id = ?1")
    Optional<Login> findLoginById(Long id);
}
