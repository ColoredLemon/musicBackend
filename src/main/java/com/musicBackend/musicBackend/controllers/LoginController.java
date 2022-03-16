package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.security.Login;
import com.musicBackend.musicBackend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "login")
public class LoginController {

    private final LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
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
