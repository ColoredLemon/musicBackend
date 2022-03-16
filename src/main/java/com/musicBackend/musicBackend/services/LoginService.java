package com.musicBackend.musicBackend.services;
import com.musicBackend.musicBackend.repositories.LoginRepository;
import com.musicBackend.musicBackend.security.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    public List<Login> getLogin() {
        
        return loginRepository.findAll();
    }
    public void addNewLogin(Login Login) {
        Optional<Login> LoginOptional = loginRepository.findLoginById(Login.getId());
        if (LoginOptional.isPresent()) {
            throw new IllegalStateException("id is being used");
        }
        loginRepository.save(Login);
        System.out.println(Login);
    }

    public void deleteLogin(Long LoginId) {
        boolean exists = loginRepository.existsById(LoginId);
        if(!exists){
            throw new IllegalStateException("Login with id " + LoginId + " does not exists.");
        }
        loginRepository.deleteById((LoginId));
    }
}
