package br.com.mercadolivre.mercadolivre.cadastros.repositories;

import br.com.mercadolivre.mercadolivre.cadastros.models.Opiniao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpiniaoRepository extends JpaRepository<Opiniao, Long> {

    @Query(value= "select avg(nota) from Opiniao")
    public Double avg();
    //List<Opiniao> pesquisarMedia(Double mediaNotas);


    @Query(value="SELECT count(nota) from Opiniao")
    public long count();
    //List<Opiniao> pesquisarTotal(Integer totalNotas);


    //Opiniao findAll(Integer nota);
}
