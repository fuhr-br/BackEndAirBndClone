package principal.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import principal.model.Reserva;
import principal.repository.ReservaRepository;

public class ReservaService {
	@Autowired
	private ReservaRepository repository;
	
	@Transactional(rollbackFor = Exception.class)
	public Iterable<Reserva> buscarTodos() {
		return repository.findAll();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Reserva salvar(Reserva reserva) {
		return repository.save(reserva);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deletarPorId(Reserva reserva) {
		 repository.deleteById(reserva.getId());
	}
	
	public Optional<Reserva> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deletar(Reserva reserva) {
		 repository.delete(reserva);
	}
	
	
 
}
