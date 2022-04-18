package com.musicBackend.musicBackend.controllers;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.security.Login;
import com.musicBackend.musicBackend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
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
