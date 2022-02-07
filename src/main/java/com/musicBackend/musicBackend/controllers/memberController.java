package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/member")
public class memberController {

        private final com.musicBackend.musicBackend.services.memberService memberService;

        @Autowired
        public memberController(com.musicBackend.musicBackend.services.memberService memberService) {
            this.memberService = memberService;
        }

        @GetMapping
        public List<member> getMembers(){

            return memberService.getMembers();
        }

        @PostMapping
        public void registerNewMember(@RequestBody member member) {

            memberService.addNewMember(member);
        }

        @DeleteMapping(path = "{memberId}")
        public void deleteMember(@PathVariable("memberId") Long memberId){

            memberService.deleteMember(memberId);
        }

        @PutMapping(path = "{memberId}")
        public void updateMember(
                @PathVariable("memberId") Long memberId,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String email){
            memberService.updateMember(memberId, name, email);
        }
}

