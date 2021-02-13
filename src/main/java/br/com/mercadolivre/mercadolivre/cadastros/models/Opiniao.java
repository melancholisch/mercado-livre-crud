package br.com.mercadolivre.mercadolivre.cadastros.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Opiniao {

    @Min(1) @Max(5)
    private Integer nota;
    private String comentario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private Long idProduto;

    @Deprecated
    public Opiniao(){

    }

    public Opiniao(Integer nota, String comentario, Long idProduto){
        this.nota = nota;
        this.comentario = comentario;
        this.idProduto = idProduto;
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