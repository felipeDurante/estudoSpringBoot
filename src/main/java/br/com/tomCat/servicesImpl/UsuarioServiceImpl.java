package br.com.tomCat.servicesImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.exception.CadastroException;
import br.com.tomCat.repositories.UsuarioRepository;
import br.com.tomCat.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UsuarioRepository repo;

	@Override
	public Usuario gravarUsuario(Usuario usuario) {
		try {
			return repo.save(usuario);
		} catch (RuntimeException e) {
			throw new CadastroException("Não foi possível gravar o usuário. Verifique os dados");
		}

	}

	@Override
	public Iterable<Usuario> findByEmail(String email) {
		return repo.findByEmail(email);
	}

}
