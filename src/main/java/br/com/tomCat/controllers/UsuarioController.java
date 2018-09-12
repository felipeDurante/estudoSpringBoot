package br.com.tomCat.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.repositories.UsuarioRepository;
import br.com.tomCat.services.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

	@Autowired
	private UsuarioService daoUsuario;

	@Autowired
	UsuarioRepository rep;

	@RequestMapping("cadastro")
	public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
		return daoUsuario.gravarUsuario(user);
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Usuario>> getAllUsers() {
		List<Usuario> usuarios = StreamSupport.stream(rep.findAll().spliterator(), false).collect(Collectors.toList());
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
}
