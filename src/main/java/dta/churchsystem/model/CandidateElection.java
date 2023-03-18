package dta.churchsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// Constroi automaticamente os gets e sets
@NoArgsConstructor// Cria um contrutor vazio
@AllArgsConstructor// Cria um contrutor com todos os atributos

@Entity// Identifica a classe como uma tabela no banco
@Table(name = "dta_candidate")// nome da tabela no banco
public class CandidateElection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Gera automaticamente o id da eleição no banco
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;
    private int countVotes;


}