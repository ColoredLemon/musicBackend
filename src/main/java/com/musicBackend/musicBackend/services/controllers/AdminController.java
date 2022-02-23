package com.musicBackend.musicBackend.services.controllers;

import com.musicBackend.musicBackend.security.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final com.musicBackend.musicBackend.services.adminService adminService;

    @Autowired
    public AdminController(com.musicBackend.musicBackend.services.adminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping//("getadmins")
    public List<Admin> getAdmin(){

        return adminService.getAdmin();
    }

    @PostMapping("addAdmin")
    public void registerNewadmin(@RequestBody Admin admin) {

        adminService.addNewAdmin(admin);
    }

    @DeleteMapping(path = "{adminId}")
    public void deleteadmin(@PathVariable("adminId") Long adminId){

        adminService.deleteAdmin(adminId);
    }
}
