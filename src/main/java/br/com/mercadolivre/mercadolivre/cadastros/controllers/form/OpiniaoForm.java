package br.com.mercadolivre.mercadolivre.cadastros.controllers.form;

import br.com.mercadolivre.mercadolivre.cadastros.models.Opiniao;
import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;
import br.com.mercadolivre.mercadolivre.cadastros.repositories.ProdutoRepository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

public class OpiniaoForm {

    @Min(1) @Max(5)
    private Integer nota;
    private String comentario;
    private Long idProduto;

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }


    public Opiniao converter(ProdutoRepository produtoRepository) {
        Optional<Produto> idProduto = produtoRepository.findById(getIdProduto());
        if(!idProduto.isPresent()){
            throw new IllegalArgumentException("produto não encontrado");
        }
        return new Opiniao(nota, comentario, idProduto.get().getId());
    }
}
