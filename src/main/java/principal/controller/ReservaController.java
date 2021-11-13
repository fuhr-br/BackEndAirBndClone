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
import principal.model.Reserva;
import principal.service.ReservaService;

@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Mensagem> salvar(@RequestBody Reserva reserva) {

		this.service.salvar(reserva);
		return new ResponseEntity<Mensagem>(new Mensagem("Status: 200 OK - Reserva Criada Com Sucesso! "),HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Reserva>> buscarTodos() {

		Iterable<Reserva> reservas = this.service.buscarTodos();

		if (reservas == null) {
			return new ResponseEntity<Iterable<Reserva>>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Iterable<Reserva>>(reservas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Reserva>> buscarPorId(@PathVariable Long id) {

		Optional<Reserva> reserva = Optional.empty();
		reserva = this.service.buscarPorId(id);

		if (reserva.isEmpty()) {
			return new ResponseEntity<Optional<Reserva>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Reserva>>(reserva, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, produces = "application/json")
	@Transactional
	public ResponseEntity<Mensagem> atualizar(@RequestBody Reserva reserva) {

		try {
			Optional<Reserva> reservaParaAtualizar = this.service.buscarPorId(reserva.getId());
			
			if (!reservaParaAtualizar.isEmpty()) {

				reservaParaAtualizar.get().setDataEntrada(reserva.getDataEntrada());
				reservaParaAtualizar.get().setDataSaida(reserva.getDataSaida());
				this.service.salvar(reservaParaAtualizar.get());

				return new ResponseEntity<Mensagem>(new Mensagem( " Status 200 OK - Reserva atualizada com sucesso!"),HttpStatus.OK);
			}

		} catch (Exception e) {
			new IllegalArgumentException("Impossível fazer atualização do objeto passado! ", e);
		}

		return new ResponseEntity<Mensagem>(new Mensagem("Erro 404 Not Found -  "
				+ "Provavel motivo: "
				+ " Locatario não encontrado!"),HttpStatus.NOT_FOUND);

	}
	
	
	
	
}
