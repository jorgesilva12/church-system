package dta.churchsystem.controller;

import dta.churchsystem.enums.RoleName;
import dta.churchsystem.model.Role;
import dta.churchsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/admin")
    @PreAuthorize("permitAll")
    public Role roleName(){return roleService.roleName(RoleName.ROLE_ADMIN);}
}
