package com.musicBackend.musicBackend.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicBackend.musicBackend.models.member;
import com.musicBackend.musicBackend.services.memberService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	member newMember;
	@Autowired
	memberService mService;
	    @GetMapping
	    public Principal getUser(Principal user) {
	    
	        return user;
	    }
	
@GetMapping("/registerMember")
public String registerMember(@RequestParam(name="name") String fullName,@RequestParam(name="email") String email) {
	String name[] = fullName.split(" ");
	String firstName= name[0];
	System.out.println(firstName);
	String lastName = name[1];
	newMember.setEmail(email);
	newMember.setFirstName(firstName);
	newMember.setLastName(lastName);
	try {
	mService.addNewMember(newMember);
	}
	catch(IllegalStateException e) {
		return "Welcome Back "+fullName;
	}
	return "Hii "+fullName+" You are now registered in the app";
}
}

