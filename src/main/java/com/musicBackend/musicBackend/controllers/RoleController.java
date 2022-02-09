package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/role")
public class RoleController {

    private final com.musicBackend.musicBackend.services.roleService roleService;
    @Autowired
    public RoleController(com.musicBackend.musicBackend.services.roleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public List<Role> getRoles(){

        return roleService.getRole();
    }

    @PostMapping(path = "registerrole")
    public void registerNewRole(@RequestBody Role role) {

        roleService.addNewRole(role);
    }

    @DeleteMapping(path = "{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){

        roleService.deleteRole(roleId);
    }
}
