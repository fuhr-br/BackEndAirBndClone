package principal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import principal.model.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, Long> {
	List<Imovel> findByBairro(String bairro);
}
