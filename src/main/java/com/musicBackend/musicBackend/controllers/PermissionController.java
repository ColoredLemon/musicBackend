package com.musicBackend.musicBackend.controllers;
import com.musicBackend.musicBackend.models.Member;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.security.Permission;
import com.musicBackend.musicBackend.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "permission")
public class PermissionController {

    private final PermissionService permissionService;
    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public String getPermissions(Model model){
        //In the "return" section, it is returning to the html page that you specify
        //The html page you specify must be placed under the resources/templates folder
        model.addAttribute("permissionList",permissionService.getPermission());
        return "permissionHome";
    }

    @GetMapping(path = "registerPermission")
    public String registerNewPermission(Model model) {
        Permission permission = new Permission();
       model.addAttribute("permission",permission);
       return "newPermission";
    }
    @PostMapping("/savePermission")
    public String savePermission(@ModelAttribute("permission") Permission permission) {
        permissionService.addNewPermission(permission);
        return "redirect:/";
    }

    @DeleteMapping(path = "/deletePermission/{PermissionId}")
    public String deletePermission(@PathVariable("PermissionId") Long PermissionId){
       permissionService.deletePermission(PermissionId);
       return "permissionHome";
    }
}
