package dta.churchsystem.service;

import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.repository.UserRepository;
import dta.churchsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> list(){return userRepository.findAll();}
    public User findByName(String name){return userRepository.findByName(name);}
    public User findByLogin(String login){return userRepository.findByLogin(login);}
    public User findInUser(String field, String value){
        User user = new User();
        if(field.equals("name")){
            return userRepository.findByName(value);
        }else if(field.equals("login")){
            return userRepository.findByLogin(value);
        }
        return user;
    }
    public User createStar(User user){return userRepository.save(user);}
    public User create(UserForm userForm) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        User user = new User();
        user.setName(userForm.getName());
        user.setCpf(userForm.getCpf());
        user.setEmail(userForm.getEmail());
        try {
            user.setDateBirth(sdf.parse(userForm.getDateBirth()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        user.setLogin(userForm.getLogin());
        user.setPassword(userForm.getPassword());
        return userRepository.save(user);
    }

    public User update(UserForm userForm) throws UserPrincipalNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        User user = userRepository.findById(userForm.getId());
        if(user==null){
            throw new RuntimeException("ID de usuário não encontrado: " + userForm.getId());
        }else{
            user.setName(userForm.getName());
            user.setCpf(userForm.getCpf());
            user.setEmail(userForm.getEmail());
            try {
                user.setDateBirth(sdf.parse(userForm.getDateBirth()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setLogin(userForm.getLogin());
            user.setPassword(userForm.getPassword());
            return userRepository.save(user);
        }
    }

    public String delete(int id) {
        User user = userRepository.findById(id);
        if(user==null) {
            throw new RuntimeException("ID de usuário não encontrado: " +id);
        }else {
            userRepository.delete(user);
            return "Usuario deletado com sucesso:"+user.toString();
        }
    }
}
