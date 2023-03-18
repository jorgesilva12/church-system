package dta.churchsystem.service;

import dta.churchsystem.model.Election;
import dta.churchsystem.model.User;
import dta.churchsystem.model.form.ElectionForm;
import dta.churchsystem.model.form.UserForm;
import dta.churchsystem.repository.ElectionRepository;
import dta.churchsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {
    @Autowired
    ElectionRepository electionRepository;

    public List<Election> list(){
        return electionRepository.findAll();
    }
    public Election findByName(String name){return electionRepository.findByName(name);}
    public Election createStar(Election election){return electionRepository.save(election);}

    public Election create(ElectionForm electionForm) {
        Election election = new Election();
        election.setName(electionForm.getName());
        election.setDateElection(electionForm.getDateElection());
        election.setActive(electionForm.getActive());
        election.setNumberVacancies(electionForm.getNumberVacancies());
        election.setCandidateElection(electionForm.getCandidateElection());
        return electionRepository.save(election);
    }
}
