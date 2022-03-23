package com.musicBackend.musicBackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeLoginController {
	@GetMapping
	public String getLogin() {
		return "/index.jsp";
	}
}
