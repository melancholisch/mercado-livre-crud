package br.com.mercadolivre.mercadolivre.cadastros.controllers.form;

import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;

import java.math.BigDecimal;

public class ProdutoForm {

    private String nome;
    private BigDecimal preco;

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto converter() {
        return new Produto(nome, preco);
    }
}
