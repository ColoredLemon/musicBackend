package com.musicBackend.musicBackend.controllers;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.security.Role;
import com.musicBackend.musicBackend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "role")
public class RoleController {

    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public String getRoles(Model model){
        model.addAttribute("getRole",roleService.getRole());
        return "roleHome";
    }

    @GetMapping(path = "/registerRole")
    public String registerNewRole(Model model) {
        Role role = new Role();
        model.addAttribute("role",role);
        return "newRole";
    }
    @PostMapping("/saveRole")
    public String saveEmployee(@ModelAttribute("role") Role role) {
        roleService.addNewRole(role);
        return "redirect:/";
    }

    @DeleteMapping(path = "/deleteRole/{roleId}")
    public String deleteRole(@PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
        return "roleHome";
    }
}
