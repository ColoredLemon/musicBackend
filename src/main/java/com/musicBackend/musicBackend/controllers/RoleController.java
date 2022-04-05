package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.security.Role;
import com.musicBackend.musicBackend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "role")
public class RoleController {

    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public List<Role> getRoles(){

        return roleService.getRole();
    }

    @PostMapping(path = "registerRole")
    public void registerNewRole(@RequestBody Role role) {

        roleService.addNewRole(role);
    }

    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){

        roleService.deleteRole(roleId);
    }
}
