package br.com.tomCat.services;

import br.com.tomCat.entitys.Usuario;

public interface UsuarioService {

	Usuario gravarUsuario(Usuario usuario);

	Usuario findByEmail(String email);
}
