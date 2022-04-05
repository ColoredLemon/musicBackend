package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("Select s FROM Role s WHERE s.id = ?1")
    Optional<Role> findRoleById(Long id);
}
