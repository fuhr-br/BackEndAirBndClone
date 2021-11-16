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

			//Cadastra um usuario
			Usuario usuario = new Usuario("Nicolas Bitenca", 18, 51984545458l, "Jack@yahoo.com", "1234");
			usuarioService.salvar(usuario);
		     usuario = new Usuario("Diego Azambuja", 34, 35985452124l, "diego@yahoo.com", "1234");
			usuarioService.salvar(usuario);
			
			//Cadastra um imovel sem endereço
			 imovelService.salvar(new Imovel(false, 1, 1, 2,"Casa de praia", 100.5, 51984545458l ,null));
			 
			//Cadastra um imovel com endereço
			Endereco endereco =  new Endereco("91150000", "Porto Alegre","Cristal","RS","Camelias", 255, "ap201");
			enderecoService.salvar(endereco);
			
			Imovel imovel = new Imovel(false, 1, 1, 2, "Apartamento",100.0, 55654521245l,endereco);
			imovelService.salvar(imovel);

	     
		};
	}

}
