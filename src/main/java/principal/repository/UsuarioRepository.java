package principal.repository;

import org.springframework.data.repository.CrudRepository;
import principal.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	
	@Query("Select usuario FROM Usuario usuario  WHERE email = :email AND senha = :senha")
	public Optional<Usuario> findByLogin(@Param("email")String email, @Param("senha") String senha);
	
	

}
