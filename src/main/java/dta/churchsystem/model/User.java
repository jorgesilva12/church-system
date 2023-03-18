package dta.churchsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data// Constroi automaticamente os gets e sets
@NoArgsConstructor// Cria um contrutor vazio
@AllArgsConstructor// Cria um contrutor com todos os atributos

@Entity// Identifica a classe como uma tabela no banco
@Table(name = "dta_user")// nome da tabela no banco
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Gera automaticamente o id do usuário no banco
    private int id;
    private String name;
    @Column(unique = true)
    private long cpf;
    private LocalDate dateBirth;
    private String email;
    private String login;
    private String password;

}
