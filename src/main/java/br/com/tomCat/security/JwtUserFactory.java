package br.com.tomCat.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.security.JwtUser.JwtUser;
import br.com.tomCat.security.enums.PerfilEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário.
	 * 
	 * @param funcionario
	 * @return JwtUser
	 */
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(),
				mapToGrantedAuthorities(PerfilEnum.ROLE_ADMIN));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}

}
