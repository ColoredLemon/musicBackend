package com.musicBackend.musicBackend.services.controllers;

import com.musicBackend.musicBackend.security.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/permission")
public class PermissionController {

    private final com.musicBackend.musicBackend.services.permissionService permissionService;
    @Autowired
    public PermissionController(com.musicBackend.musicBackend.services.permissionService permissionService) {
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
