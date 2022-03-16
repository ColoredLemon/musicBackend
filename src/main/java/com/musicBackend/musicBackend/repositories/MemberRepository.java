package com.musicBackend.musicBackend.repositories;

import com.musicBackend.musicBackend.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("Select s FROM Member s WHERE s.email = ?1")

    Optional<Member> findmemberByEmail(String email);

    Optional<Member> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Member a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableMember(String email);

}
