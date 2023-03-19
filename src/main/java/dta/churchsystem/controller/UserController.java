package dta.churchsystem.controller;

import dta.churchsystem.model.User;
import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/list")
    public List<User> list(){return userService.list();}
    @GetMapping(value = "/find")
    public User findInUser(@RequestParam(value = "field") String field, @RequestParam(value = "value") String value){return userService.findInUser(field,value);}
    @PutMapping("/update")
    public User update(@RequestBody UserForm userForm) throws UserPrincipalNotFoundException {return userService.update(userForm);}
    @PostMapping("/create")
    public User create(@RequestBody @Valid UserForm userForm){return userService.create(userForm);}
    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "id") int id){return userService.delete(id);}


}
