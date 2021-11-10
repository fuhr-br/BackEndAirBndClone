package principal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import principal.repository.ClienteRepository;
import principal.model.Cliente;

@Service
public class ServiceCliente {
	
	@Autowired
	private ClienteRepository repository;


	@Transactional(rollbackFor = Exception.class)
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}

	@Transactional(rollbackFor = Exception.class)
	public Cliente atualizar(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente Login(String email, String senha) {
		return repository.findByEmail(email, senha);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deletar(Cliente cliente) {
		 repository.deleteById(cliente.getId());
	}

}
