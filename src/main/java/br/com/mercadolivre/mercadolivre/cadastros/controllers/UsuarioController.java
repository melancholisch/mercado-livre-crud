package br.com.mercadolivre.mercadolivre.cadastros.controllers;

import br.com.mercadolivre.mercadolivre.cadastros.controllers.dto.UsuarioDto;
import br.com.mercadolivre.mercadolivre.cadastros.controllers.form.UsuarioForm;
import br.com.mercadolivre.mercadolivre.cadastros.models.Usuario;
import br.com.mercadolivre.mercadolivre.cadastros.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){

        Usuario usuario = form.converter();
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));


    }
}
