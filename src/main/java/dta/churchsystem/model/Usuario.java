package dta.churchsystem.model;

import java.sql.Date;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    public String cpf;

    @Email(message = "Email inválido")
    public String email;

    public Date dataNascimento;
    public String senha;
}
