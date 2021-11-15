package principal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImovelTest {
	Endereco endereco = new Endereco("91150000", "Porto Alegre", "Cristal", "RS", "Camelias", 255, "ap201");
	Usuario usuario = new Usuario("Jack", 34, 333333, "andersonfuhr@yahoo", "@a1234");
	Imovel imovel = new Imovel(false, 1, 1, 2, "Casa de praia", 100.0, endereco, usuario);

	@Test
	void testEndereco() throws Exception{

		assertEquals(imovel.getEndereco(), endereco);

		Endereco enderecoValida = new Endereco("90050230", "Porto Alegre", "Cristal", "SP", "Oliveira", 255, "ap01");

		imovel.setEndereco(enderecoValida);
		assertEquals(imovel.getEndereco(), enderecoValida);

	}

	@Test
	void testImovelUsuario()throws Exception {

		assertEquals(imovel.getUsuario(), usuario);
		
		Usuario usuarioValida = new Usuario("Anderson", 38, 4333333, "andersonfuhr@yahoo.com", "@a1aa234");
		
		imovel.setUsuario(usuarioValida);
		assertEquals(imovel.getUsuario(), usuarioValida);

	}

	@Test
	void testArCoondicionado() throws Exception{

		assertEquals(imovel.getArCondicionado(), false);

		imovel.setArCondicionado(null);
		assertEquals(imovel.getArCondicionado(), null);

		imovel.setArCondicionado(true);
		assertEquals(imovel.getArCondicionado(), true);

	}

	@Test
	void testCamaSolteiro()throws Exception {
		assertEquals(imovel.getCamaSolteiro(), 1);

		imovel.setCamaSolteiro(5);
		assertEquals(imovel.getCamaSolteiro(), 5);

		imovel.setCamaSolteiro(null);
		assertEquals(imovel.getCamaSolteiro(), null);

	}

	@Test
	void testCamaCasal()throws Exception {
		assertEquals(imovel.getCamaCasal(), 1);

		imovel.setCamaCasal(5);
		assertEquals(imovel.getCamaCasal(), 5);

		imovel.setCamaCasal(null);
		assertEquals(imovel.getCamaCasal(), null);

	}

	@Test
	void testQuartos()throws Exception {
		assertEquals(imovel.getQuartos(), 2);

		imovel.setQuartos(5);
		assertEquals(imovel.getQuartos(), 5);

		imovel.setQuartos(null);
		assertEquals(imovel.getQuartos(), null);

	}

	@Test
	void testDescricao() throws Exception{

		assertEquals(imovel.getDescricao(), "Casa de praia");

		imovel.setDescricao("Apartamento quatro quadras do mar");
		assertEquals(imovel.getDescricao(), "Apartamento quatro quadras do mar");

		imovel.setDescricao(null);
		assertEquals(imovel.getDescricao(), null);

	}

	@Test
	void testURLImagem() throws Exception{

		assertEquals(imovel.getImagemURL(), null);

		imovel.setImagemURL("httt://servidor/imagem");
		assertEquals(imovel.getImagemURL(), "httt://servidor/imagem");

	}

}
