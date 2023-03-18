package dta.churchsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dta.churchsystem.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT count(*)>0 FROM Usuario u WHERE (u.cpf = ?1) and (u.senha = ?2)")
    Boolean login(String cpf, String senha);

}
