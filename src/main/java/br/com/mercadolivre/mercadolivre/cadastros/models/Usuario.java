package br.com.mercadolivre.mercadolivre.cadastros.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @NotBlank
    @Email
    private String login;
    @NotBlank
    private String senha;

    @NotNull
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Deprecated
    public Usuario(){

    }

    public Usuario(String login, String senha, LocalDateTime dataCriacao) {
        this.login = login;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public void setId(Long id) {
        this.id = id;
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
