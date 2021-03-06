package principal.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import principal.model.Reserva;
import principal.repository.ReservaRepository;

@Service
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
