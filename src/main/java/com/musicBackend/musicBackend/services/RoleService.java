package com.musicBackend.musicBackend.services;
import com.musicBackend.musicBackend.repositories.RoleRepository;
import com.musicBackend.musicBackend.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {


    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> getRole() {
        return roleRepository.findAll();
    }

    public void addNewRole(Role role) {
        Optional<Role> RoleOptional = roleRepository.findRoleById(role.getId());
        if (RoleOptional.isPresent()) {
            throw new IllegalStateException("id is being used");
        }
        roleRepository.save(role);
        System.out.println(role);
    }

    public void deleteRole(Long RoleId) {
        boolean exists = roleRepository.existsById(RoleId);
        if(!exists){
            throw new IllegalStateException("Role with id " + RoleId + " does not exists.");
        }
        roleRepository.deleteById((RoleId));
    }
}
