package principal.controller;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import principal.model.Imovel;
import principal.model.Usuario;
import principal.service.EnderecoService;
import principal.service.ImovelService;
import principal.service.UsuarioService;

@Controller
@RequestMapping(value = "/imovel")
public class ImovelController {

	@Autowired
	private ImovelService service;
	@Autowired
	private EnderecoService serviceEndereco;
	@Autowired
	private UsuarioService	usuarioService;
	

	
	
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Mensagem> salvar(@RequestBody Imovel imovel) {
		
		if(imovel.getEndereco() == null) {
			return new ResponseEntity<Mensagem>(new Mensagem("Error 400 Bad Request - Motivo : "
					+ "Campo Endereço Vazio!"),HttpStatus.BAD_REQUEST);
			
		}else if(imovel.getUsuario() == null) {
			return new ResponseEntity<Mensagem>(new Mensagem("Error 400 Bad Request - Motivo : "
					+ "Campo Locatário Está Vazio!"),HttpStatus.BAD_REQUEST);
		}
		Usuario user = usuarioService.buscarPorEmail(imovel.getUsuario().getEmail());
	    if(user == null || !user.getSenha().equals(imovel.getUsuario().getSenha())) {
	    	return new ResponseEntity<Mensagem>(new Mensagem("Error 400 Bad Request - Motivo : "
					+ "Senha ou email não confere!"),HttpStatus.BAD_REQUEST);
	    }
		
		
		imovel.setUsuario(usuarioService.buscarPorEmail(imovel.getUsuario().getEmail())); 
		serviceEndereco.salvar(imovel.getEndereco());
		this.service.salvar(imovel);
		
		return new ResponseEntity<Mensagem>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Imovel>> buscarPorId(@PathVariable Long id) {

		Optional<Imovel> imovel = this.service.buscarPorId(id);

		if (imovel.isEmpty()) {
			return new ResponseEntity<Optional<Imovel>>( HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Optional<Imovel>>(imovel, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Imovel>> buscarTodos() {

		Iterable<Imovel> imovel = this.service.buscarTodos();

		if (imovel == null) {
			return new ResponseEntity<Iterable<Imovel>>( HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Iterable<Imovel>>(imovel, HttpStatus.OK);
	}

	@RequestMapping(value = "/remover/{imovelId}", method = RequestMethod.DELETE, produces = "application/json")
	@Transactional
	public ResponseEntity<Mensagem> deletar(@PathVariable Long imovelId) {

		Optional<Imovel> imovel = Optional.empty();
		imovel = this.service.buscarPorId(imovelId);

		if (imovel.isEmpty()) {
			return new ResponseEntity<Mensagem>(new Mensagem("Status: 404 Not Found - Imovel inválido "),HttpStatus.NOT_FOUND);
		}
		this.service.deletar(imovelId);
		return new ResponseEntity<Mensagem>(new Mensagem("Status: NO_CONTENT - Imóvel Deletado com sucesso! "), HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Imovel> atualizar(@RequestBody Imovel imovel) {

		try {
			Optional<Imovel> imovelParaAtualizar = Optional.empty();
			imovelParaAtualizar = this.service.buscarPorId(imovel.getId());

			if (!imovelParaAtualizar.isEmpty()) {

				imovelParaAtualizar.get().setArCondicionado(imovel.getArCondicionado());
				imovelParaAtualizar.get().setCamaCasal(imovel.getCamaCasal());
				imovelParaAtualizar.get().setCamaSolteiro(imovel.getCamaSolteiro());
				imovelParaAtualizar.get().setDescricao(imovel.getDescricao());
				imovelParaAtualizar.get().setQuartos(imovel.getQuartos());

				this.service.salvar(imovelParaAtualizar.get());

				return new ResponseEntity<Imovel>(imovelParaAtualizar.get(), HttpStatus.OK);
			}

		} catch (Exception e) {
			new IllegalArgumentException("Impossível fazer atualização do objeto passado! ", e);
		}

		return new ResponseEntity<Imovel>(HttpStatus.NOT_FOUND);

	}

}
