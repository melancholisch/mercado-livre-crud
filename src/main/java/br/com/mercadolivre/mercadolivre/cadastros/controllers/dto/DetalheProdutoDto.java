package br.com.mercadolivre.mercadolivre.cadastros.controllers.dto;

import br.com.mercadolivre.mercadolivre.cadastros.models.Opiniao;
import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;

import java.math.BigDecimal;
import java.util.List;

public class DetalheProdutoDto {

    private String nome;
    private BigDecimal preco;
    private Long id;
    private List<Opiniao> opinioes;
    private Double mediaNotas;
    private long totalNotas;


    public DetalheProdutoDto(Produto produto, Double mediaNotas, long totalNotas) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.opinioes = produto.getOpinioes();
        this.mediaNotas = mediaNotas;
        this.totalNotas = totalNotas;
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

    public Double getMediaNotas() {
        return mediaNotas;
    }

    public long getTotalNotas() {
        return totalNotas;
    }
}
