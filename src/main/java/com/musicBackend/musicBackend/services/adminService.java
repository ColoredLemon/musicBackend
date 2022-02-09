package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.security.Admin;
import com.musicBackend.musicBackend.repositories.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class adminService {

    private final adminRepository adminRepository;

    @Autowired
    public adminService(com.musicBackend.musicBackend.repositories.adminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        Optional<Admin> adminOptional = adminRepository.findAdminByEmail(admin.getEmail());
        if (adminOptional.isPresent()) {
            throw new IllegalStateException("email is being used");
        }
        adminRepository.save(admin);
        System.out.println(admin);
    }

    public void deleteAdmin(Long adminId) {
        boolean exists = adminRepository.existsById(adminId);
        if(!exists){
            throw new IllegalStateException("admin with id " + adminId + " does not exists.");
        }
        adminRepository.deleteById((adminId));
    }
}
