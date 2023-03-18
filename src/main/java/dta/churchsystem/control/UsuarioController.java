package dta.churchsystem.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dta.churchsystem.model.Usuario;
import dta.churchsystem.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public Iterable<Usuario> getAll() {
        return usuarioService.getAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return usuarioService.get(id);
    }

    @PostMapping("/usuario/save")
    public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario.cpf, usuario.senha);
    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return usuarioService.delete(id);
    }

}