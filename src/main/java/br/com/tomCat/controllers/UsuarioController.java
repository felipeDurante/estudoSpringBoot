package br.com.tomCat.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.repositories.UsuarioRepository;
import br.com.tomCat.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	UsuarioRepository rep;

	@ApiOperation(value = "create a new user for the system", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully user created") })
	@PostMapping(value = "cadastro", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario createUser(@RequestBody @Valid Usuario user) {
		return usuarioService.gravarUsuario(user);
	}

	@GetMapping(value = "getAllUsers", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Usuario> getAllUsers() {
		List<Usuario> usuarios = StreamSupport.stream(rep.findAll().spliterator(), false).collect(Collectors.toList());
		return usuarios;
	}

	@GetMapping(value = "getUserByEmail/{email}")
	public Iterable<Usuario> getUserByEmail(@PathVariable(value = "email", required = true) String email) {
		return usuarioService.findByEmail(email);

	}
}
