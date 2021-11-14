package principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import principal.model.ArquivoDB;

@Repository
public interface ArquivoDBRepository extends JpaRepository<ArquivoDB, String> {

}