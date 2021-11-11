package principal.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import principal.repository.ClienteRepository;
import principal.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	
	@Transactional(rollbackFor = Exception.class)
	public Iterable<Cliente> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deletar(Cliente cliente) {
		 repository.deleteById(cliente.getId());
	}
	
	public Cliente buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		return repository.findById(id);
	}
	

}
