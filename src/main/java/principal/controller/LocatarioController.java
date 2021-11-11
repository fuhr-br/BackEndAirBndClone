package principal.controller;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import principal.model.Locatario;
import principal.service.LocatarioService;
import principal.validacoes.ValidaEmail;

@RestController
@RequestMapping(value = "/locatario")
public class LocatarioController {

	@Autowired
	private LocatarioService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Locatario> salvar(@RequestBody Locatario locatario) {

		this.service.salvar(locatario);
		return new ResponseEntity<Locatario>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Locatario> buscarPorEmail(@PathVariable String email) {

		if (!ValidaEmail.isNotEmpty.and(ValidaEmail.isEmail).test(email)) {
			throw new IllegalArgumentException("Formato de Email não é válido!");
		}

		Locatario locatario = this.service.buscarPorEmail(email);
		if (locatario == null) {
			return new ResponseEntity<Locatario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Locatario>(locatario, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Locatario>> buscarTodos() {

		Iterable<Locatario> locatarios = this.service.buscarTodos();

		if (locatarios == null) {
			return new ResponseEntity<Iterable<Locatario>>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Iterable<Locatario>>(locatarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Locatario>> buscarPorId(@PathVariable Long id) {

		Optional<Locatario> locatario = Optional.empty();
		locatario = this.service.buscarPorId(id);

		if (locatario.isEmpty()) {
			return new ResponseEntity<Optional<Locatario>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Locatario>>(locatario, HttpStatus.OK);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, produces = "application/json")
	@Transactional
	public ResponseEntity<Mensagem> atualizar(@RequestBody Locatario locatario) {

		try {
			Locatario locatarioParaAtualizar = this.service.buscarPorEmail(locatario.getEmail());
			
			if (locatarioParaAtualizar != null ) {

				locatarioParaAtualizar.setEmail(locatario.getEmail());
				locatarioParaAtualizar.setSenha(locatario.getSenha());
				locatarioParaAtualizar.setTelefone(locatario.getTelefone());
				this.service.salvar(locatarioParaAtualizar);

				return new ResponseEntity<Mensagem>(HttpStatus.OK);
			}

		} catch (Exception e) {
			new IllegalArgumentException("Impossível fazer atualização do objeto passado! ", e);
		}

		return new ResponseEntity<Mensagem>(new Mensagem("Erro 404 Not Found -  "
				+ "Provavel motivo: "
				+ " Locatario não encontrado!"),HttpStatus.NOT_FOUND);

	}

}

	

