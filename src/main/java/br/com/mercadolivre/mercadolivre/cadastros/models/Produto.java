package br.com.mercadolivre.mercadolivre.cadastros.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Produto {


    private String nome;
    private BigDecimal preco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="produto", cascade = CascadeType.ALL)
    private List<Opiniao> opinioes;

    @Deprecated
    public Produto() {

    }

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Long getId() {
        return id;
    }

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }

}
