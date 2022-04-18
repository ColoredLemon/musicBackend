package com.musicBackend.musicBackend.controllers;
import com.musicBackend.musicBackend.models.Member;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.security.Admin;
import com.musicBackend.musicBackend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAdmin")
    public String getAdmin(Model model){
        model.addAttribute("getAdmin",adminService.getAdmin());
        return "adminHome";
    }

    @GetMapping("addAdmin")
    public String registerNewAdmin(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin",admin);
        return "newAdmin";
    }
    @PostMapping("/saveAdmin")
    public String saveEmployee(@ModelAttribute("admin") Admin admin) {
        adminService.addNewAdmin(admin);
        return "redirect:/";
    }

    @DeleteMapping(path = "/deleteAdmin/{adminId}")
    public String deleteadmin(@PathVariable("adminId") Long adminId){
        adminService.deleteAdmin(adminId);
        return "adminHome";
    }
}
