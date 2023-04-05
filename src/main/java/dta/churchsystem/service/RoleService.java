package dta.churchsystem.service;

import dta.churchsystem.enums.RoleName;
import dta.churchsystem.model.Role;
import dta.churchsystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Optional<Role> findByRoleName(RoleName roleName){return roleRepository.findByRoleName(roleName);}
    public Role roleName(RoleName roleName){
        Optional<Role> roleOptional = roleRepository.findByRoleName(roleName);
        Role role = roleOptional.get();
        return role;
    }
    public Role create(Role role){return roleRepository.save(role);}
}
