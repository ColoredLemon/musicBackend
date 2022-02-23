package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.member;
import com.musicBackend.musicBackend.repositories.memberRepository;
import com.musicBackend.musicBackend.security.token.ConfirmationToken;
import com.musicBackend.musicBackend.security.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class memberService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final memberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public memberService(com.musicBackend.musicBackend.repositories.memberRepository memberRepository, ConfirmationTokenService confirmationTokenService) {
        this.memberRepository = memberRepository;
        this.confirmationTokenService = confirmationTokenService;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();

    }

    public List<member> getListOfMembers() {
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

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return memberRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }
    @Transactional
    public String signUpMember(member member) {
        boolean userExists = memberRepository
                .findByEmail(member.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        memberRepository.save(member);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                member
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);
        return token;
    }
    public int enableMember(String email) {
        return memberRepository.enableMember(email);
    }
}
