package br.com.tomCat.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.tomCat.entitys.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByNome(String nome);
}
