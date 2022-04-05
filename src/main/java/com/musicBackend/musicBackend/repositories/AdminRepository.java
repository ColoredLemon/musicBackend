package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.security.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("Select s FROM Admin s WHERE s.email = ?1")
    Optional<Admin> findAdminByEmail(String email);

}
