package dta.churchsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data// Constroi automaticamente os gets e sets
@NoArgsConstructor// Cria um contrutor vazio
@AllArgsConstructor// Cria um contrutor com todos os atributos

@Entity// Identifica a classe como uma tabela no banco
@Table(name = "dta_election")// nome da tabela no banco
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Gera automaticamente o id da eleição no banco
    private int id;
    private String name;
    private boolean active;
    private LocalDate dateElection;
    private int numberVacancies;
    private List<CandidateElection> candidateElection;
}
