package br.com.tomCat.servicesImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.repositories.UsuarioRepository;
import br.com.tomCat.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UsuarioRepository repo;

	@Override
	public ResponseEntity<Usuario> gravarUsuario(Usuario usuario) {

		Usuario novoUsu = repo.save(usuario);
		ResponseEntity<Usuario> response = new ResponseEntity<Usuario>(novoUsu, HttpStatus.CREATED);
		return response;

	}

}
