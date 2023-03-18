package dta.churchsystem.init;

import dta.churchsystem.model.User;
import dta.churchsystem.repository.UserRepository;
import dta.churchsystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartAplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userService.findByName("administrador");
        if(user == null){
            user = new User();
            user.setName("administrador");
            user.setCpf(123456789);
            user.setLogin("admin");
            user.setEmail("admin@church.com");
            user.setPassword("123456");
            userService.createStar(user);
        }
    }


}
