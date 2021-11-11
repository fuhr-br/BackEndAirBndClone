package principal.repository;

import org.springframework.data.repository.CrudRepository;

import principal.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Cliente findByEmail(String Email);

}
