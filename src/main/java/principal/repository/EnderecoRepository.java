package principal.repository;

import org.springframework.data.repository.CrudRepository;

import principal.model.Endereco;
import principal.model.Imovel;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	Imovel findByBairro(String bairro);
}
