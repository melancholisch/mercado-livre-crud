package br.com.mercadolivre.mercadolivre.cadastros.controllers.dto;

import br.com.mercadolivre.mercadolivre.cadastros.models.Usuario;

import java.time.LocalDateTime;

public class UsuarioDto {

    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private Long id;

    public UsuarioDto(Usuario usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.dataCriacao = usuario.getDataCriacao();
        this.id = usuario.getId();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Long getId() {
        return id;
    }
}
