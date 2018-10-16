package br.com.tomCat.services;

import br.com.tomCat.entitys.Usuario;

public interface UsuarioService {

	Usuario gravarUsuario(Usuario usuario);

	Iterable<Usuario> findByEmail(String email);
}
