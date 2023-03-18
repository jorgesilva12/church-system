package dta.churchsystem.controller;

import dta.churchsystem.model.User;
import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> list(){return userService.list();}

    @PostMapping("/create")
    public User create(@Valid @RequestBody UserForm userForm){return userService.create(userForm);}


}
