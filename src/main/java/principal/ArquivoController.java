package principal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/")
public class ArquivoController {

	@Autowired
	private ArquivioService service;

	@PostMapping("/upload")
	public ResponseEntity<MensagemResposta> uploadArquivo(@RequestParam("file") MultipartFile arquivo) {
		String message = "";
		try {
			service.store(arquivo);

			message = "Uploaded the file successfully: " + arquivo.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MensagemResposta(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + arquivo.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MensagemResposta(message));
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListaArquivos() {
		List<ResponseFile> files = service.getTodosOsArquivos().map(dbArquivo -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbArquivo.getId()).toUriString();

			return new ResponseFile(dbArquivo.getNome(), fileDownloadUri, dbArquivo.getTipo(), dbArquivo.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getArquivo(@PathVariable String id) {
		ArquivoDB arquivoDB = service.getArquivo(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivoDB.getNome() + "\"")
				.body(arquivoDB.getData());
	}
}