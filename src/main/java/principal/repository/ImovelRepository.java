package principal.repository;

import org.springframework.data.repository.CrudRepository;

import principal.model.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, Long> {

}
