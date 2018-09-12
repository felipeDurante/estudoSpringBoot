package br.com.tomCat.services;

import org.springframework.http.ResponseEntity;

import br.com.tomCat.entitys.Usuario;

public interface UsuarioService {

	public ResponseEntity<Usuario> gravarUsuario(Usuario usuario);
}
