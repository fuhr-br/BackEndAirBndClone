package principal.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import principal.model.Endereco;
import principal.repository.EnderecoRepository;

@Service
public class EnderecoService  {

		@Autowired
		private EnderecoRepository repository;
		
		
		@Transactional(rollbackFor = Exception.class)
		public Endereco salvar(Endereco endereco) {
			return repository.save(endereco);
		}
		
		@Transactional(rollbackFor = Exception.class)
		public Optional<Endereco> buscarPorId(Long id) {
			return repository.findById(id);
		}
	
}
