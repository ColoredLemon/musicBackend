package com.musicBackend.musicBackend.services.repositories;

import com.musicBackend.musicBackend.security.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface permissionRepository extends JpaRepository<Permission, Long> {
    @Query("Select s FROM Permission s WHERE s.id = ?1")
    Optional<Permission> findPermissionById(Long id);
}
