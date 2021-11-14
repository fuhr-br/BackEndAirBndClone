package principal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoDBRepository extends JpaRepository<ArquivoDB, String> {

}