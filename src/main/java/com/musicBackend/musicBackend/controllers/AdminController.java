package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.security.Admin;
import com.musicBackend.musicBackend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
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
