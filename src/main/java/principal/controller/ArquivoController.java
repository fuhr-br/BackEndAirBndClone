package principal.controller;

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

import principal.model.ArquivoDB;
import principal.model.ModeloArquivoDeResposta;
import principal.service.ArquivioService;

@Controller
@RequestMapping("/")
public class ArquivoController {

	@Autowired
	private ArquivioService service;

	@PostMapping("/upload")
	public ResponseEntity<Mensagem> uploadArquivo(@RequestParam("file") MultipartFile arquivo) {
		String mensagem = "";
		try {
			service.armazenar(arquivo);

			mensagem = "Uploaded do arquivo com sucesso: " + arquivo.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new Mensagem(mensagem));
		} catch (Exception e) {
			mensagem = "Não foi possível fazer o upload do arquivo: " + arquivo.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Mensagem(mensagem));
		}
	}

	@GetMapping("/imagens")
	public ResponseEntity<List<ModeloArquivoDeResposta>> getListaArquivos() {

		List<ModeloArquivoDeResposta> files = service.getTodosOsArquivos().map(dbArquivo -> {
			String arquivoDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/imagem/")
					.path(dbArquivo.getId()).toUriString();

			return new ModeloArquivoDeResposta(dbArquivo.getNome(), arquivoDownloadUri, dbArquivo.getTipo(),
					dbArquivo.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/imagem/{id}")
	public ResponseEntity<byte[]> getArquivo(@PathVariable String id) {
		ArquivoDB arquivoDB = service.getArquivo(id);
		
		if (arquivoDB.getNome() == null) {
			return 	new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "anexo; nome do arquivo=\"" + arquivoDB.getNome() + "\"")
				.body(arquivoDB.getData());
	}

}