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

	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email) {

		if (!ValidaEmail.isNotEmpty.and(ValidaEmail.isEmail).test(email)) {
			throw new IllegalArgumentException("Formato de Email não é válido!");
		}

		Cliente cliente = this.service.buscarPorEmail(email);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {

		Iterable<Cliente> clientes = this.service.buscarTodos();

		if (clientes == null) {
			return new ResponseEntity<Iterable<Cliente>>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Iterable<Cliente>>(clientes, HttpStatus.OK);
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Cliente>> buscarPorId(@PathVariable Long id) {

		Optional<Cliente> cliente = Optional.empty();
		cliente = this.service.buscarPorId(id);

		if (cliente.isEmpty()) {
			return new ResponseEntity<Optional<Cliente>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Cliente>>(cliente, HttpStatus.OK);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, produces = "application/json")
	@Transactional
	public ResponseEntity<Mensagem> atualizar(@RequestBody Cliente cliente) {

		try {
			Cliente clienteParaAtualizar = this.service.buscarPorEmail(cliente.getEmail());
			
			if (clienteParaAtualizar != null ) {

				clienteParaAtualizar.setEmail(cliente.getEmail());
				clienteParaAtualizar.setSenha(cliente.getSenha());
				clienteParaAtualizar.setTelefone(cliente.getTelefone());
				this.service.salvar(clienteParaAtualizar);

				return new ResponseEntity<Mensagem>(HttpStatus.OK);
			}

		} catch (Exception e) {
			new IllegalArgumentException("Impossível fazer atualização do objeto passado! ", e);
		}

		return new ResponseEntity<Mensagem>(new Mensagem("Erro 404 Not Found -  "
				+ "Provavel motivo: "
				+ " Cliente não encontrado!"),HttpStatus.NOT_FOUND);

	}

}
//esta classe poderá ser colocada em pacote separado e utilizada como padrão de resposta
final class Mensagem{
    public String msg;

    public Mensagem(String msg) {
        this.msg = msg;
    }
}