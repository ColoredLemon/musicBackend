package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.security.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/login")
public class LoginController {

    private final com.musicBackend.musicBackend.services.loginService loginService;
    @Autowired
    public LoginController(com.musicBackend.musicBackend.services.loginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping
    public List<Login> getLogins(){

        return loginService.getLogin();
    }

    @PostMapping(path = "registerLogin")
    public void registerNewLogin(@RequestBody Login Login) {

        loginService.addNewLogin(Login);
    }

    @DeleteMapping(path = "{LoginId}")
    public void deleteLogin(@PathVariable("LoginId") Long LoginId){

        loginService.deleteLogin(LoginId);
    }
}
