package dta.churchsystem.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dta.churchsystem.model.Resposta;
import dta.churchsystem.model.Usuario;
import dta.churchsystem.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Resposta resposta;

    public Iterable<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public ResponseEntity<?> get(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        } else {
            resposta.setMensagem("Usuário não encontrado");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> save(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            resposta.setMensagem("Nome é obrigatório");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        } else if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            resposta.setMensagem("CPF é obrigatório");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        } else {

            String senhaAntiga = senhaAntiga(usuario.getId());
            if (usuario.getSenha() != senhaAntiga) {
                if (usuario.getSenha() != null && !usuario.getSenha().isEmpty())
                    usuario.setSenha(md5(usuario.getSenha()));
                else
                    usuario.setSenha(md5(usuario.getCpf()));
            } else if (usuario.getId() == 0) {
                usuario.setSenha(md5(usuario.getCpf()));
            }

            HttpStatus status = (usuario.getId() == 0) ? HttpStatus.CREATED : HttpStatus.OK;
            return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), status);
        }

    }

    public ResponseEntity<?> delete(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            resposta.setMensagem("Usuário excluído com sucesso");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);
        } else {
            resposta.setMensagem("Usuário não encontrado");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Resposta> login(String cpf, String senha) {
        senha = md5(senha);
        if (usuarioRepository.login(cpf, senha)) {
            resposta.setMensagem("Usuário encontrado");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);
        } else {
            resposta.setMensagem("Usuário não encontrado");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.NOT_FOUND);
        }
    }

    // Auxiliares --------------------------------------------------------
    private String senhaAntiga(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get().getSenha();
        } else {
            return null;
        }
    }

    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
