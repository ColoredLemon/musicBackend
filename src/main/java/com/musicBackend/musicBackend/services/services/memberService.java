package com.musicBackend.musicBackend.services.services;

import com.musicBackend.musicBackend.models.member;
import com.musicBackend.musicBackend.repositories.memberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class memberService {

    private final memberRepository memberRepository;

    @Autowired
    public memberService(com.musicBackend.musicBackend.repositories.memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<member> getMembers() {
        return memberRepository.findAll();
    }

    public void addNewMember(member member) {
        Optional<member> memberOptional = memberRepository.findmemberByEmail(member.getEmail());
        if (memberOptional.isPresent()) {
            throw new IllegalStateException("email is being used");
        }
        memberRepository.save(member);
        System.out.println(member);
    }

    public void deleteMember(Long memberId) {
        boolean exists = memberRepository.existsById(memberId);
        if(!exists){
            throw new IllegalStateException("Member with id " + memberId + " does not exists.");
        }
        memberRepository.deleteById((memberId));
    }

    @Transactional
    public void updateMember(Long memberId, String name, String email) {
        member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException(
                "Member with id " + memberId + " does not exists"));
        if (name != null && name.length() > 0 && !Objects.equals(member.getFirstName(), name)){
            member.setFirstName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(member.getEmail(), email)){
            Optional<member> memberOptional = memberRepository.findmemberByEmail(email);
            if (memberOptional.isPresent()){
                throw new IllegalStateException("email is taken");
            }
            member.setEmail(email);
        }
    }
}
