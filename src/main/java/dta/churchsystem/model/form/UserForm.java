package dta.churchsystem.model.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    @NotEmpty(message = "O nome não pode está em branco")
    private String name;
    @NotEmpty(message = "O cpf não pode está em branco")
    private long cpf;
    @NotEmpty(message = "A data de nascimento não pode está em branco")
    private LocalDate dateBirth;
    @NotEmpty(message = "O email não pode está em branco")
    private String email;
    @NotEmpty(message = "O login não pode está em branco")
    private String login;
    @NotEmpty(message = "A senha não pode está em branco")
    @Size(min = 4, max = 8, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String password;
}
