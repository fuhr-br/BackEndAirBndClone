package principal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import principal.model.Imovel;
import principal.repository.ImovelRepository;
@Service
public class ImovelService {

	@Autowired
	private ImovelRepository repository;
	
	@Transactional(rollbackFor = Exception.class)
	public Iterable<Imovel> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public Imovel salvar(Imovel imovel) {
		return repository.save(imovel);
	}
	@Transactional(rollbackFor = Exception.class)
	public void deletar(Long id) {
	 repository.deleteById(id);
	}
	
	public Optional<Imovel> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	
	
	
}
