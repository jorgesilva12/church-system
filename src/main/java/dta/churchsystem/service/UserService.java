package dta.churchsystem.service;

import dta.churchsystem.model.User;
import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public Optional<User> findByUsername(String username){return userRepository.findByUsername(username);}

    public User createStart(User user) {return userRepository.save(user);}

    public User create(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setUsername(userForm.getUsername());
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setEmail(userForm.getEmail());
        userForm.getRoles().forEach(role -> {
            user.getRoles().add(role);
        });
        return userRepository.save(user);
    }

    public User update(UserForm userForm) {
        Optional<User> userOptional = this.findByUsername(userForm.getUsername());
        User user = new User();
        if(!userOptional.isEmpty()){
            user = userOptional.get();
            user.setId(userOptional.get().getId());
            user.setName(userForm.getName());
            user.setUsername(userForm.getUsername());
            user.setPassword(encoder.encode(userForm.getPassword()));
            user.setEmail(userForm.getEmail());
            user.getRoles().clear();
            User finalUser = user;
            userForm.getRoles().forEach(role -> {
                finalUser.getRoles().add(role);
            });
            return userRepository.save(finalUser);
        }else{
            throw new RuntimeException("User not found with username: " + userForm.getUsername());
        }
    }
    public String delete(UUID uuid) {
        User user = userRepository.findAllById(uuid);
        if(user ==null){
            throw new RuntimeException("User not found.");
        }else {
            userRepository.deleteById(uuid);
            return "User deleted with sucess!!!";
        }
    }
}
