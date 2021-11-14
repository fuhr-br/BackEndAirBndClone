package principal.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import principal.model.ArquivoDB;
import principal.repository.ArquivoDBRepository;

@Service
public class ArquivioService {

	@Autowired
	private ArquivoDBRepository arquivoDBRepository;

	public ArquivoDB armazenar(MultipartFile arquivo) throws IOException {
		String nomeDoArquivo = StringUtils.cleanPath(arquivo.getOriginalFilename());
		ArquivoDB arquivoDB = new ArquivoDB(nomeDoArquivo, arquivo.getContentType(), arquivo.getBytes());

		return arquivoDBRepository.save(arquivoDB);
	}

	public ArquivoDB getArquivo(String id) {
		return arquivoDBRepository.findById(id).get();
	}

	public Stream<ArquivoDB> getTodosOsArquivos() {
		return arquivoDBRepository.findAll().stream();
	}
}