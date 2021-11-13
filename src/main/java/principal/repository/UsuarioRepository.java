package principal.repository;

import org.springframework.data.repository.CrudRepository;

import principal.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByEmail(String email);

}
