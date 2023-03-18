package dta.churchsystem.service;

import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.repository.UserRepository;
import dta.churchsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> list(){
        return userRepository.findAll();
    }

    public User findByName(String name){return userRepository.findByName(name);}
    public User createStar(User user){return userRepository.save(user);}

    public User create(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setCpf(userForm.getCpf());
        user.setEmail(userForm.getEmail());
        user.setDateBirth(userForm.getDateBirth());
        user.setLogin(userForm.getLogin());
        user.setPassword(userForm.getPassword());
        return userRepository.save(user);
    }
}
