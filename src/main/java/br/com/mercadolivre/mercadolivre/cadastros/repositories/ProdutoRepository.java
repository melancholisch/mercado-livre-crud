package br.com.mercadolivre.mercadolivre.cadastros.repositories;

import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
