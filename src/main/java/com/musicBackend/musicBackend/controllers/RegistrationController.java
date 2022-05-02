package com.musicBackend.musicBackend.controllers;
import com.musicBackend.musicBackend.models.Member;
import com.musicBackend.musicBackend.models.MemberDTO;
import com.musicBackend.musicBackend.services.MemberService;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.security.RegistrationRequest;
import com.musicBackend.musicBackend.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping(path = "registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final MemberService memberService;

    @GetMapping("/register")
    public String registration(Model model) {
        Member member = new Member();
        model.addAttribute("newMember", member);
        return "SignUp";
    }

    @PostMapping("/saveRegister")
    public String registration(@ModelAttribute("newMember") MemberDTO member, BindingResult bindingResult){
        registrationService.register(member);
        return "SignUp";
    }



//    @PostMapping
//    public String register(@RequestBody RegistrationRequest request, Model model) {
//        model.addAttribute("register",registrationService.register(request));
//        return registrationService.register(request);
//    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }
}
