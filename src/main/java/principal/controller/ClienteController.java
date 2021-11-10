package principal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import principal.model.Cliente;
import principal.model.DadosDeLogin;
import principal.repository.ClienteRepository;
import principal.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/salvar/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		this.service.salvar(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/buscar/email", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cliente> login(@PathVariable String email) {

		Cliente cliente = this.service.buscarPorEmail(email);

		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
