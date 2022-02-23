package com.musicBackend.musicBackend.services.repositories;

import com.musicBackend.musicBackend.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface roleRepository extends JpaRepository<com.musicBackend.musicBackend.services.security.Role, Long> {
    @Query("Select s FROM Role s WHERE s.id = ?1")
    Optional<com.musicBackend.musicBackend.services.security.Role> findRoleById(Long id);
}
