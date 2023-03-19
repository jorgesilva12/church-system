package dta.churchsystem.model.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private int id;
    @NotBlank(message = "O campo Nome não pode ser vazio")
    private String name;
    @CPF
    private String cpf;
    private String dateBirth;
    @Email
    @NotBlank(message = "O campo Email não pode ser vazio")
    private String email;
    @NotBlank(message = "O campo Login não pode ser vazio")
    private String login;
    @NotBlank(message = "O campo Senha não pode ser vazio")
    @Size(min = 4, max = 8, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String password;
}
