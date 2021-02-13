package br.com.mercadolivre.mercadolivre.cadastros.repositories;

import br.com.mercadolivre.mercadolivre.cadastros.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
