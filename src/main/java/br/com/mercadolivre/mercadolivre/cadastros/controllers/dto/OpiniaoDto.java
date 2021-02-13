package br.com.mercadolivre.mercadolivre.cadastros.controllers.dto;

import br.com.mercadolivre.mercadolivre.cadastros.models.Opiniao;
import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;

import java.util.ArrayList;

public class OpiniaoDto {

    private Integer nota;
    private String comentario;
    private Long id;
    private Produto produto;
    private Long idProduto;

    public OpiniaoDto(Opiniao opiniao) {
        this.nota = opiniao.getNota();
        this.comentario = opiniao.getComentario();
        this.id = opiniao.getId();
        this.produto = opiniao.getProduto();
        this.idProduto = opiniao.getIdProduto();
    }

    public Integer getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Long getIdProduto() {
        return idProduto;
    }
}
