package dta.churchsystem.model.form;

import dta.churchsystem.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private String name;
    private String username;
    private String password;
    private String email;
    private List<Role> roles = new ArrayList<>();
}
