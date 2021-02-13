package br.com.mercadolivre.mercadolivre.cadastros.controllers;

import br.com.mercadolivre.mercadolivre.cadastros.controllers.dto.DetalheProdutoDto;
import br.com.mercadolivre.mercadolivre.cadastros.controllers.dto.OpiniaoDto;
import br.com.mercadolivre.mercadolivre.cadastros.controllers.dto.ProdutoDto;
import br.com.mercadolivre.mercadolivre.cadastros.controllers.form.OpiniaoForm;
import br.com.mercadolivre.mercadolivre.cadastros.controllers.form.ProdutoForm;
import br.com.mercadolivre.mercadolivre.cadastros.models.Opiniao;
import br.com.mercadolivre.mercadolivre.cadastros.models.Produto;
import br.com.mercadolivre.mercadolivre.cadastros.repositories.OpiniaoRepository;
import br.com.mercadolivre.mercadolivre.cadastros.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController

public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private OpiniaoRepository opiniaoRepository;

    @PostMapping(value = "/produtos")
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder){

        Produto produto = form.converter();
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));

    }

    @PostMapping(value = "/produtos/{id}/opinioes")
    public ResponseEntity<OpiniaoDto> cadastrar(@RequestBody @Valid OpiniaoForm form, UriComponentsBuilder uriBuilder){

        Opiniao opiniao = form.converter(produtoRepository);
        opiniaoRepository.save(opiniao);

        URI uri = uriBuilder.path("/opinioes/{id}").buildAndExpand(opiniao.getId()).toUri();
        return ResponseEntity.created(uri).body(new OpiniaoDto(opiniao));
    }

    //detalhando o produto (mostrando o valor medio e quantidade das notas)
    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<DetalheProdutoDto> exibir(@PathVariable Long id, Integer nota){

         Double mediaNotas = opiniaoRepository.avg();
         long totalNotas = opiniaoRepository.count();

        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            return ResponseEntity.ok(new DetalheProdutoDto(produto.get(), mediaNotas, totalNotas));
        }
        return ResponseEntity.notFound().build();
    }
}
