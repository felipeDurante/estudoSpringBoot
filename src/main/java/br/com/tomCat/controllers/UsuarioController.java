package br.com.tomCat.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.repositories.UsuarioRepository;
import br.com.tomCat.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

	@ApiOperation(value = "Cadastro de usuario", nickname = "Cadastro de usuários", notes = "Efetua o cadastro do usuario", response = Usuario.class, tags = {
			"Cadastro", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Sucesso ao cadastrar novo usuario", response = Usuario.class),
			@ApiResponse(code = 400, message = "Cadastro inválido"),
			@ApiResponse(code = 401, message = "Cadastro não autorizado") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Usuario createUser(@RequestBody @Valid Usuario user) {
		return usuarioService.gravarUsuario(user);
	}

	@ApiOperation(value = "Lista todos usuários", nickname = "listaTodosUsuarios", notes = "Lista todos os usuários cadastrados no sistema.", response = Usuario.class, tags = {
			"Consulta", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Sucesso ao listas todos os usuários", response = Usuario.class),
			  @ApiResponse(code = 400, message = "Consulta inválida."),
		        @ApiResponse(code = 401, message = "Consulta não autorizada.") })
	@GetMapping(value = "getAllUsers", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Usuario> getAllUsers() {
		List<Usuario> usuarios = StreamSupport.stream(rep.findAll().spliterator(), false).collect(Collectors.toList());
		return usuarios;
	}
	 @ApiOperation(value = "Consulta usuario existente por email.", nickname = "consultaPorEmail", 
			 notes = "Esta operação tem por objetivo consultar um usuario existente por email.", 
			 response = Usuario.class, tags={ "Consulta", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Sucesso ao consultar usuario por email.", response = Usuario.class),
	        @ApiResponse(code = 400, message = "Consulta inválida."),
	        @ApiResponse(code = 401, message = "Consulta não autorizada."),
	        @ApiResponse(code = 403, message = "Acesso não permitido."),
	        @ApiResponse(code = 404, message = "Nenhum usuario encontrado para pesquisa."),
	        @ApiResponse(code = 500, message = "Erro interno ao tentar realizar a consulta por email.") })
	@GetMapping(value = "getUserByEmail/{email}")
	public Iterable<Usuario> getUserByEmail(@ApiParam(value = "email do usuario.",required=true) @PathVariable(value = "email", required = true) String email) {
		return usuarioService.findByEmail(email);

	}
}
