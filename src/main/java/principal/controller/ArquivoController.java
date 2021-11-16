package principal.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/imagem")
public class ArquivoController {

	@Autowired
	private ArquivioService service;

	// envia umarquivo e retorna a URL do mesmo em forma de STRING
	
	@CrossOrigin
	@PostMapping("/upload")
	public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile arquivo) {
		String mensagem = "";
		try {
			service.armazenar(arquivo);

			List<ModeloArquivoDeResposta> arquivos = service.getTodosOsArquivos().map(dbArquivo -> {
				String arquivoDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/imagem/download/")
						.path(dbArquivo.getId()).toUriString();

				return new ModeloArquivoDeResposta(dbArquivo.getNome(), arquivoDownloadUri, dbArquivo.getTipo(),
						dbArquivo.getData().length);
			}).collect(Collectors.toList());

			
			
			return ResponseEntity.status(HttpStatus.OK).body(arquivos.get(arquivos.size() - 1).getUrl());

		} catch (Exception e) {
			mensagem = "Não foi possível fazer o upload do arquivo: " + arquivo.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(mensagem);
		}
	}

	// Lista todos os arquivos no banco
	
	@CrossOrigin
	@GetMapping("/imagens")
	public ResponseEntity<List<ModeloArquivoDeResposta>> getListaArquivos() {

		List<ModeloArquivoDeResposta> arquivos = service.getTodosOsArquivos().map(dbArquivo -> {
			String arquivoDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/imagem/download/")
					.path(dbArquivo.getId()).toUriString();

			return new ModeloArquivoDeResposta(dbArquivo.getNome(), arquivoDownloadUri, dbArquivo.getTipo(),
					dbArquivo.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(arquivos);
	}

	// Procura por Id e retorna uma URL em forma de STRING
	
	@CrossOrigin
	@GetMapping("/busca/{id}")
	public ResponseEntity<String> getURLArquivo(@PathVariable String id) {

		List<ModeloArquivoDeResposta> arquivos = service.getTodosOsArquivos()
				.filter(dbArquivo -> dbArquivo.getId().equals(id)).map(dbArquivo -> {

					String arquivoDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/imagem/download/")
							.path(dbArquivo.getId()).toUriString();

					return new ModeloArquivoDeResposta(dbArquivo.getNome(), arquivoDownloadUri, dbArquivo.getTipo(),
							dbArquivo.getData().length);
				}).collect(Collectors.toList());
		if (arquivos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Status: 404 NOT FOUND - Motivo: Imagem não encontrada! ");
		}
		return ResponseEntity.status(HttpStatus.OK).body(arquivos.get(0).getUrl());
	}

	// Procura por nome do arquivo e retorna uma URL em forma de STRING
	
	@CrossOrigin
	@GetMapping("/nome/{nome}")
	public ResponseEntity<String> gerURLArquivo(@PathVariable String nome) {
		List<ModeloArquivoDeResposta> arquivos = service.getTodosOsArquivos()
				.filter(dbArquivo -> dbArquivo.getNome().equals(nome)).map(dbArquivo -> {

					String arquivoDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/imagem/download/")
							.path(dbArquivo.getId()).toUriString();

					return new ModeloArquivoDeResposta(dbArquivo.getNome(), arquivoDownloadUri, dbArquivo.getTipo(),
							dbArquivo.getData().length);
				}).collect(Collectors.toList());
		if (arquivos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Status: 404 NOT FOUND - Motivo: Imagem não encontrada ou nome está incorreto! ");
		}
		return ResponseEntity.status(HttpStatus.OK).body(arquivos.get(0).getUrl());
	}

	// Faz o dowload do arquivo pelo ID
	
	@CrossOrigin
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> getArquivo(@PathVariable String id) {
		ArquivoDB arquivoDB = service.getArquivo(id);
		try {
			if (arquivoDB.getData() == null) {
				return new ResponseEntity<byte[]>( HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "anexo; nome do arquivo=\"" + arquivoDB.getNome() + "\"")
					.body(arquivoDB.getData());

		} catch (NoSuchElementException e) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}

	}

}