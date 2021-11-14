package principal;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivioService {

	@Autowired
	private ArquivoDBRepository arquivoDBRepository;

	public ArquivoDB store(MultipartFile file) throws IOException {
		String nomeDoArquivo = StringUtils.cleanPath(file.getOriginalFilename());
		ArquivoDB arquivoDB = new ArquivoDB(nomeDoArquivo, file.getContentType(), file.getBytes());

		return arquivoDBRepository.save(arquivoDB);
	}

	public ArquivoDB getArquivo(String id) {
		return arquivoDBRepository.findById(id).get();
	}

	public Stream<ArquivoDB> getTodosOsArquivos() {
		return arquivoDBRepository.findAll().stream();
	}
}