package principal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImovelTest {

	@Test
	void testGetCidade() {
		Imovel imovel = Imovel.builder().cidade("Porto Alegre").build();
		assertEquals(imovel.getCidade(), "Porto Alegre");

	}

	@Test
	void testSetCidade() {
		Imovel imovel = Imovel.builder().cidade("alvorada").build();

		imovel.setCidade(null);
		assertEquals(imovel.getCidade(), "Porto Alegre");

		imovel.setCidade("alvorada");
		assertEquals(imovel.getCidade(), "Porto Alegre");

	}

	@Test
	void testGetArcondicionado() {
		Imovel imovel = Imovel.builder().arCondicionado(false).build();

		assertEquals(imovel.getArCondicionado(), false);

	}

	@Test
	void testSetArcondicionado() {
		Imovel imovel = Imovel.builder().arCondicionado(false).build();

		imovel.setArCondicionado(null);
		assertEquals(imovel.getArCondicionado(), null);

		imovel.setArCondicionado(true);
		assertEquals(imovel.getArCondicionado(), true);

	}

	@Test
	void testGetCamaSolteiro() {
		Imovel imovel = Imovel.builder().camaSolteiro(2).build();

		assertEquals(imovel.getCamaSolteiro(), 2);

	}

	@Test
	void testSetCamaSolteiro() {
		Imovel imovel = Imovel.builder().camaSolteiro(1).build();

		imovel.setCamaSolteiro(0);
		assertEquals(imovel.getCamaSolteiro(), 0);

		imovel.setCamaSolteiro(-1);
		assertEquals(imovel.getCamaSolteiro(), 0);

	}

	@Test
	void testGetCamaCasal() {
		Imovel imovel = Imovel.builder().camaCasal(2).build();

		assertEquals(imovel.getCamaCasal(), 2);

	}

	@Test
	void testSetCamaCasal() {
		Imovel imovel = Imovel.builder().camaCasal(2).build();

		imovel.setCamaCasal(0);
		assertEquals(imovel.getCamaCasal(), 0);

		imovel.setCamaSolteiro(-1);
		assertEquals(imovel.getCamaCasal(), 0);

	}

	@Test
	void testGetQuartos() {
		Imovel imovel = Imovel.builder().quartos(4).build();

		assertEquals(imovel.getQuartos(), 4);

	}

	@Test
	void testSetQuartos() {
		Imovel imovel = Imovel.builder().quartos(4).build();

		imovel.setQuartos(0);
		assertEquals(imovel.getQuartos(), 0);

		imovel.setCamaSolteiro(-1);
		assertEquals(imovel.getQuartos(), 0);

	}

	@Test
	void testGetDescricao() {
		Imovel imovel = Imovel.builder().descricao("Casa de Praia").build();

		assertEquals(imovel.getDescricao(), "Casa de Praia");

	}

	@Test
	void testSetDescricao() {
		Imovel imovel = Imovel.builder().descricao("Casa de Praia").build();

		imovel.setDescricao("Casa");
		assertEquals(imovel.getDescricao(), "Casa");

		imovel.setDescricao("");
		assertEquals(imovel.getDescricao(), "");

		imovel.setDescricao(null);
		assertEquals(imovel.getDescricao(), null);

	}

}
