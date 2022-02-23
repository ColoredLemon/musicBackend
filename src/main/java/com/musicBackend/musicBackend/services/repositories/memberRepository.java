package com.musicBackend.musicBackend.services.repositories;

import com.musicBackend.musicBackend.models.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface memberRepository extends JpaRepository<member, Long> {

    @Query("Select s FROM member s WHERE s.email = ?1")
    Optional<member> findmemberByEmail(String email);
}
