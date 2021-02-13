package br.com.mercadolivre.mercadolivre.cadastros.controllers.dto;

import br.com.mercadolivre.mercadolivre.cadastros.models.Opiniao;
import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDto {

        private String nome;
        private BigDecimal preco;
        private Long id;
        private List<Opiniao> opinioes;

        public ProdutoDto(Produto produto) {
            this.nome = produto.getNome();
            this.preco = produto.getPreco();
            this.id = produto.getId();
            this.opinioes = produto.getOpinioes();
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
