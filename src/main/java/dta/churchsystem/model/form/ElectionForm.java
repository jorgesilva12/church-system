package dta.churchsystem.model.form;

import dta.churchsystem.model.CandidateElection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectionForm {
    @NotEmpty(message = "O nome não pode está em branco")
    private String name;
    @NotEmpty(message = "Informe se está ativo ou inativo")
    private Boolean active;
    @NotEmpty(message = "A data de eleição não pode está em branco")
    private LocalDate dateElection;
    @NotEmpty(message = "O email não pode está em branco")
    private int numberVacancies;
    @NotEmpty(message = "Deve haver ao menos 1 candidato")
    private List<CandidateElection> candidateElection;
   
}
