package dta.churchsystem.init;

import dta.churchsystem.model.User;
import dta.churchsystem.repository.UserRepository;
import dta.churchsystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class StartAplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userService.findByName("administrador");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(user == null){
            user = new User();
            user.setName("administrador");
            user.setCpf("123456789");
            user.setDateBirth(sdf.parse("20/10/1990"));
            user.setLogin("admin");
            user.setEmail("admin@church.com");
            user.setPassword("123456");
            userService.createStar(user);
        }
    }


}
