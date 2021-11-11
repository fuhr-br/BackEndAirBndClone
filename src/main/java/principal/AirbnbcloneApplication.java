package principal;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import principal.model.Cliente;
import principal.model.Endereco;
import principal.model.Imovel;
import principal.model.ImovelTipo;
import principal.model.Locatario;
import principal.service.ClienteService;
import principal.service.EnderecoService;
import principal.service.ImovelService;
import principal.service.LocatarioService;

@SpringBootApplication
public class AirbnbcloneApplication {

	private static final Logger log = LoggerFactory.getLogger(AirbnbcloneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirbnbcloneApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteService repository, 
									ImovelService imovelService,
									EnderecoService enderecoService,
									LocatarioService locatarioService
						) {
		return (args) -> {
			// salvar cliente
			repository.salvar(new Cliente("Jack", 34, 333333, "andersonfuhr@yahoo.com", "@a1234"));
			repository.salvar(new Cliente("joão", 34, 333333, "diego@yahoo.com", "@a1234"));

	      // buscar todos clientes
	      log.info("Buscar todos os clientes:");
	      log.info("-------------------------------");
	      Iterable<Cliente> clientes = repository.buscarTodos();
	      for (Cliente customer : clientes) {
	        log.info(customer.toString());
	      }
	      log.info("");

			// procurar cliente  por ID
			Cliente cliente = repository.buscarPorEmail("andersonfuhr@yahoo.com");
			log.info("Buscar cliente por email");
			log.info("--------------------------------");
			log.info(cliente.toString());

			log.info("Buscar cliente por id");
			log.info("--------------------------------");
			Optional<Cliente> pessoa = Optional.empty();
			pessoa = repository.buscarPorId(2l);

			log.info(pessoa.toString() + "\n");
			//Cadastra um locatario
			Locatario locatario = new Locatario("Jack", 34, 333333, "andersonfuhr@yahoo.com", "@a1234");
			locatarioService.salvar(locatario);
			
			//Cadastra um imovel, mas primeiro é necessário um locatario 
			 imovelService.salvar(new Imovel(false, 1, 1, true, 2,
						"Casa de praia", ImovelTipo.CASA,null, locatario));
			 
			Endereco endereco =  new Endereco("91150000", "Camelia", 255, "ap 201");
			enderecoService.salvar(endereco);
			
			imovelService.salvar(new Imovel(false, 1, 1, true, 2,
						"Casa de praia", ImovelTipo.CASA,endereco, locatario));

	     
		};
	}

}
