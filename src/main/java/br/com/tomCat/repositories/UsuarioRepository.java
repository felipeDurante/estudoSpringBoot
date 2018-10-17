package br.com.tomCat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tomCat.entitys.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Iterable<Usuario> findByEmail(String email);

}
