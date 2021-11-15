package principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import principal.model.Endereco;
import principal.model.Imovel;
import principal.model.Usuario;
import principal.service.EnderecoService;
import principal.service.ImovelService;
import principal.service.UsuarioService;

@SpringBootApplication
public class AirbnbcloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbcloneApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(	ImovelService imovelService,
									EnderecoService enderecoService,
									UsuarioService usuarioService
						) {
		return (args) -> {

			//Cadastra um locatario
			Usuario usuario = new Usuario("Jack", 34, 333333, "andersonfuhr@yahoo", "@a1234");
			usuarioService.salvar(usuario);
		     usuario = new Usuario("Jack", 34, 333333, "diego@yahoo", "1234");
			usuarioService.salvar(usuario);
			
			//Cadastra um imovel, mas primeiro é necessário um locatario 
			 imovelService.salvar(new Imovel(false, 1, 1, 2,
						"Casa de praia", 100.5,null, usuario));
			 
			Endereco endereco =  new Endereco("91150000", "Porto Alegre","Cristal","RS","Camelias", 255, "ap201"	);
			enderecoService.salvar(endereco);
			
			imovelService.salvar(new Imovel(false, 1, 1,2,
						"Casa de praia",100.0,endereco, usuario));

	     
		};
	}

}
