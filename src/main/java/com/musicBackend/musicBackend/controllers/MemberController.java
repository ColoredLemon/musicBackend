package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Member;
import com.musicBackend.musicBackend.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping(path = "member")
@AllArgsConstructor
public class MemberController {

        private final MemberService memberService;

    @GetMapping()
        public List<Member> getMembers(){

            return memberService.getListOfMembers();
        }

    @GetMapping("allMembers")
    public List<Member> getAllMembers(){

        return memberService.getListOfMembers();
    }

        @PostMapping(path = "/addMember")
        public void registerNewMember(@RequestBody Member member) {

            memberService.addNewMember(member);
        }

        @DeleteMapping(path = "/{memberId}")
        public void deleteMember(@PathVariable("memberId") Long memberId){

            memberService.deleteMember(memberId);
        }

        @PutMapping(path = "/{memberId}")
        public void updateMember(
                @PathVariable("memberId") Long memberId,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String email){
            memberService.updateMember(memberId, name, email);
        }
}

