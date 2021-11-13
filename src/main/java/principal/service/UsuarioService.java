package principal.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import principal.model.Usuario;
import principal.repository.UsuarioRepository;

@Service
public class UsuarioService {
		
	@Autowired
	private UsuarioRepository repository;
	
	
	@Transactional(rollbackFor = Exception.class)
	public Iterable<Usuario> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deletar(Usuario usuario) {
		 repository.deleteById(usuario.getId());
	}
	
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Optional<Usuario> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	
}
