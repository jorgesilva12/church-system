package dta.churchsystem.controller;

import dta.churchsystem.model.Election;
import dta.churchsystem.model.User;
import dta.churchsystem.model.form.ElectionForm;
import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.service.ElectionService;
import dta.churchsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election")
public class ElectionController {

    @Autowired
    ElectionService electionService;

    @GetMapping("/list")
    public List<Election> list(){return electionService.list();}

    @PostMapping("/create")
    public Election create(@Valid @RequestBody ElectionForm electionForm){return electionService.create(electionForm);}


}
