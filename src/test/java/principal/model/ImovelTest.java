package principal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImovelTest {

	@Test
	void testGetCidade() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		assertEquals(imovel.getCidade(), "Porto Alegre");

	}

	@Test
	void testSetCidade() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		imovel.setCidade(null);
		assertEquals(imovel.getCidade(), "Porto Alegre");

		imovel.setCidade("alvorada");
		assertEquals(imovel.getCidade(), "Porto Alegre");

	}

	@Test
	void testGetArcondicionado() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		assertEquals(imovel.getArCondicionado(), false);

	}

	@Test
	void testSetArcondicionado() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		imovel.setArCondicionado(null);
		assertEquals(imovel.getArCondicionado(), null);

		imovel.setArCondicionado(true);
		assertEquals(imovel.getArCondicionado(), true);

	}

	@Test
	void testGetCamaSolteiro() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		assertEquals(imovel.getCamaSolteiro(), 2);

	}

	@Test
	void testSetCamaSolteiro() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		imovel.setCamaSolteiro(0);
		assertEquals(imovel.getCamaSolteiro(), 0);

		imovel.setCamaSolteiro(-1);
		assertEquals(imovel.getCamaSolteiro(), 0);

	}

	@Test
	void testGetCamaCasal() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		assertEquals(imovel.getCamaCasal(), 2);

	}

	@Test
	void testSetCamaCasal() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		imovel.setCamaCasal(0);
		assertEquals(imovel.getCamaCasal(), 0);

		imovel.setCamaSolteiro(-1);
		assertEquals(imovel.getCamaCasal(), 0);

	}

	@Test
	void testGetQuartos() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		assertEquals(imovel.getQuartos(), 4);

	}

	@Test
	void testSetQuartos() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		imovel.setQuartos(0);
		assertEquals(imovel.getQuartos(), 0);

		imovel.setCamaSolteiro(-1);
		assertEquals(imovel.getQuartos(), 0);

	}
	
	@Test
	void testGetDescricao() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia", 
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 
				100.5, 5185452158l, "91111000", "Canoas", 
				"Rio Branco", "RS",	"Ijui", 255, "ap 201");	
			
		assertEquals(imovel.getDescricao(), "Casa de Praia");
	
	}
	
	@Test
	void testSetDescricao() {
		Imovel imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Canoas", "Rio Branco", "RS", "Ijui", 255, "ap 201");

		imovel.setDescricao("Casa");
		assertEquals(imovel.getDescricao(), "Casa");

		imovel.setDescricao("");
		assertEquals(imovel.getDescricao(), "");
		
		imovel.setDescricao(null);
		assertEquals(imovel.getDescricao(), null);

	}
	
	

}
