package principal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import principal.model.Locatario;
import principal.repository.LocatarioRepository;

@Service
public class LocatarioService {
		
	@Autowired
	private LocatarioRepository repository;
	
	
	@Transactional(rollbackFor = Exception.class)
	public Iterable<Locatario> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public Locatario salvar(Locatario locatario) {
		return repository.save(locatario);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deletar(Locatario locatario) {
		 repository.deleteById(locatario.getId());
	}
	
	public Locatario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Optional<Locatario> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	
}
