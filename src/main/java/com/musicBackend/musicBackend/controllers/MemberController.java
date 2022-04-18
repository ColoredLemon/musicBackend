package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Member;
import org.springframework.stereotype.Controller;
import com.musicBackend.musicBackend.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("permitAll()")
@Controller
@RequestMapping(path = "members")
@AllArgsConstructor
public class MemberController {

        @Autowired
        private final MemberService memberService;

    @GetMapping("/getAllMembers")
    public String getMembers(Model model){
        model.addAttribute("allMemList", memberService.getListOfMembers());
        return "member";
    }

    @GetMapping("/addNewMember")
    public String addNewMember(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "newemployee";
    }

    @PostMapping("/saveMember")
    public String saveEmployee(@ModelAttribute("member") Member member) {
        memberService.addNewMember(member);
        return "redirect:/";
    }
    @DeleteMapping(path = "/deleteMember/{memberId}")
    public String deleteMember(@PathVariable("memberId") Long memberId){
       memberService.deleteMember(memberId);
       return "member";
    }

    @PutMapping(path = "/updateMember/{memberId}")
    public String updateMember(
            @PathVariable("memberId") Long memberId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        memberService.updateMember(memberId, name, email);
        return "update";
    }


/*    @GetMapping()
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
        }*/
}

