package principal.repository;

import org.springframework.data.repository.CrudRepository;

import principal.model.Locatario;

public interface LocatarioRepository extends CrudRepository<Locatario, Long> {

}
