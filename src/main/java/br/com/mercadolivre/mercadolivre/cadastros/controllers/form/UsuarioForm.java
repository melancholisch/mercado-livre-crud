package br.com.mercadolivre.mercadolivre.cadastros.controllers.form;

import br.com.mercadolivre.mercadolivre.cadastros.models.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UsuarioForm {

    @NotBlank @Email
    private String login;
    @NotBlank @Size(min=6)
    private String senha;

    @PastOrPresent @NotNull
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Usuario converter() {
        return new Usuario(login, new BCryptPasswordEncoder().encode(senha), dataCriacao);
    }
}
