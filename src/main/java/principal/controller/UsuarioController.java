package principal.controller;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import principal.model.Usuario;
import principal.service.UsuarioService;
import principal.validacoes.ValidaEmail;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@CrossOrigin
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Mensagem> salvar(@RequestBody Usuario usuario) {

		this.service.salvar(usuario);
		return new ResponseEntity<Mensagem>(
				new Mensagem("Status: 200OK - Usuário: " + usuario.getNome() + " cadastrado com succeso!"),
				HttpStatus.CREATED);

	}
	@CrossOrigin
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email) {

		if (!ValidaEmail.isNotEmpty.and(ValidaEmail.isEmail).test(email)) {
			throw new IllegalArgumentException("Formato de Email não é válido!");
		}

		Usuario usuario = this.service.buscarPorEmail(email);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "/login", params = { "email",
			"senha" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Mensagem> login(@RequestParam("email") String email, @RequestParam("senha") String senha) {

		Optional<Usuario> usuario = this.service.login(email, senha);
		if (usuario.isEmpty()) {
			return new ResponseEntity<Mensagem>(new Mensagem("Login não autorizado!"), HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Mensagem>(new Mensagem("Login autorizado!"), HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {

		Iterable<Usuario> usuarios = this.service.buscarTodos();

		if (usuarios == null) {
			return new ResponseEntity<Iterable<Usuario>>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Iterable<Usuario>>(usuarios, HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Usuario>> buscarPorId(@PathVariable Long id) {

		Optional<Usuario> usuario = Optional.empty();
		usuario = this.service.buscarPorId(id);

		if (usuario.isEmpty()) {
			return new ResponseEntity<Optional<Usuario>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, produces = "application/json")
	@Transactional
	public ResponseEntity<Mensagem> atualizar(@RequestBody Usuario usuario) {

		try {
			Usuario locatarioParaAtualizar = this.service.buscarPorEmail(usuario.getEmail());

			if (locatarioParaAtualizar != null) {

				locatarioParaAtualizar.setEmail(usuario.getEmail());
				locatarioParaAtualizar.setSenha(usuario.getSenha());
				locatarioParaAtualizar.setTelefone(usuario.getTelefone());
				this.service.salvar(locatarioParaAtualizar);

				return new ResponseEntity<Mensagem>(HttpStatus.OK);
			}

		} catch (Exception e) {
			new IllegalArgumentException("Impossível fazer atualização do objeto passado! ", e);
		}

		return new ResponseEntity<Mensagem>(
				new Mensagem("Erro 404 Not Found -  " + "Provavel motivo: " + " Locatario não encontrado!"),
				HttpStatus.NOT_FOUND);

	}

}
