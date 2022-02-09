package com.musicBackend.musicBackend.services;
import com.musicBackend.musicBackend.security.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class permissionService {

    private final com.musicBackend.musicBackend.repositories.permissionRepository permissionRepository;

    @Autowired
    public permissionService(com.musicBackend.musicBackend.repositories.permissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }
    public List<Permission> getPermission() {
        
        return permissionRepository.findAll();
    }

    public void addNewPermission(Permission permission) {
        Optional<Permission> permissionOptional = permissionRepository.findPermissionById(permission.getId());
        if (permissionOptional.isPresent()) {
            throw new IllegalStateException("id is being used");
        }
        permissionRepository.save(permission);
        System.out.println(permission);
    }

    public void deletePermission(Long permissionId) {
        boolean exists = permissionRepository.existsById(permissionId);
        if(!exists){
            throw new IllegalStateException("permission with id " + permissionId + " does not exists.");
        }
        permissionRepository.deleteById((permissionId));
    }
}
