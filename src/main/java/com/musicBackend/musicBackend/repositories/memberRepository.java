package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface memberRepository extends JpaRepository<member, Long> {

    @Query("Select s FROM member s WHERE s.email = ?1")

    Optional<member> findmemberByEmail(String email);

    Optional<member> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE member a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableMember(String email);

}
