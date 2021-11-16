package principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
			
			//Cadastra um imovel
			 imovelService.salvar(new Imovel(false, 2, 2, 4, "Casa de Praia", 100.5, 5185452158l, "91111000", "Porto Alegre", 
					"Rio Branco", "RS",	"Ijui", 255, "ap 201"));
			 
		
			imovelService.salvar(new Imovel(false, 2, 2, 4, "Casa de Praia", 100.5, 5185452158l, "91111000", "Porto Alegre", 
					"Cristal", "RS",	"Ijui", 255, "ap 201"));

	     
		};
	}

}
