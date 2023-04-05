package dta.churchsystem.init;

import dta.churchsystem.model.Role;
import dta.churchsystem.model.User;
import dta.churchsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private StartRole startRole;

    @Autowired
    private PasswordEncoder encoder;
    @Value("${security.password}")
    private String password;

    @Override
    public void run(String... args) throws Exception {

        // Criação automatica da tabelas de Roles
        Role roleAdmin = startRole.startRole();

        // Criação automatica do usuário admin
        Optional<User> userOptional = userService.findByUsername("admin");
        if(userOptional.isEmpty()){
            User user = new User();
            user.setName("administrador");
            user.setUsername("admin");
            user.setPassword(encoder.encode(password));
            user.setEmail("admin@admin.com.br");
            user.getRoles().add(roleAdmin);
            userService.createStart(user);
        }
    }
}
