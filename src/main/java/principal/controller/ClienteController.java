package principal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import principal.model.Cliente;

import principal.service.ClienteService;
import principal.validacoes.ValidaEmail;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {

		this.service.salvar(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/buscar/email", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email) {

		if (!ValidaEmail.isNotEmpty.and(ValidaEmail.isEmail).test(email)) {
			throw new IllegalArgumentException("Formato de Email não é válido!");
		}

		Cliente cliente = this.service.buscarPorEmail(email);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Cliente>> getAll() {

		Iterable<Cliente> clientes = this.service.buscarTodos();

		if (clientes == null) {
			return new ResponseEntity<Iterable<Cliente>>(HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Iterable<Cliente>>(clientes, HttpStatus.OK);
	}

}
