package dta.churchsystem.init;

import dta.churchsystem.enums.RoleName;
import dta.churchsystem.model.Role;
import dta.churchsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StartRole {

    @Autowired
    private RoleService roleService;

    public Role startRole(){
        List<RoleName> roleNames = Arrays.asList(RoleName.values());//Lista com as roles a serem criadas
        Role roleAdmin = new Role();//Role admin a ser usada no usuário admin
        for(int i = 0; i < roleNames.size() ; i++) {
            Optional<Role> roleOptional = roleService.findByRoleName(roleNames.get(i));//verifica se já existe no banco
            Role role = new Role();//role auxilizar
            if (roleOptional.isEmpty()) {//se não achou cria
                role.setRoleName(roleNames.get(i));
                if (roleNames.get(i) == RoleName.ROLE_ADMIN) {//se for adim já cria e salva no role admin
                    roleAdmin = roleService.create(role);
                } else {
                    roleService.create(role);//se não, só cria
                }
            } else {
                if (roleNames.get(i) == RoleName.ROLE_ADMIN) roleAdmin = roleOptional.get();//se achou e for admin salva na role admin
            }
        }
        return roleAdmin;
    }
}
