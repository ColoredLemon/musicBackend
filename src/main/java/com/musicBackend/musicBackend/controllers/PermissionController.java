package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.security.Permission;
import com.musicBackend.musicBackend.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "permission")
public class PermissionController {

    private final PermissionService permissionService;
    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<Permission> getPermissions(){

        return permissionService.getPermission();
    }

    @PostMapping(path = "registerPermission")
    public void registerNewPermission(@RequestBody Permission Permission) {

       permissionService.addNewPermission(Permission);
    }

    @DeleteMapping(path = "{PermissionId}")
    public void deletePermission(@PathVariable("PermissionId") Long PermissionId){

       permissionService.deletePermission(PermissionId);
    }
}
