package principal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnderecoTest {

	private Endereco endereco = new Endereco("91150000", "Porto Alegre", "Cristal", "RS", "Camelias", 255, "ap201");

	@Test
	void testGetCep() throws Exception{
		assertEquals(endereco.getCep(), "91150000");
	}

	@Test
	void testGetCidade() throws Exception{
		assertEquals(endereco.getCidade(), "Porto Alegre");

	}

	@Test
	void testGetBairro() throws Exception{
		assertEquals(endereco.getBairro(), "Cristal");

	}

	@Test
	void testGetUf() throws Exception{
		assertEquals(endereco.getUf(), "RS");

	}

	@Test
	void testGeRua() throws Exception{
		assertEquals(endereco.getRua(), "Camelias");

	}

	@Test
	void testGetNumero() throws Exception{
		assertEquals(endereco.getNumero(), 255);

	}

	@Test
	void testComplemento() throws Exception{

		assertEquals(endereco.getComplemento(), "ap201");

		endereco.setComplemento(null);
		assertEquals(endereco.getComplemento(), null);

		endereco.setComplemento("");
		assertEquals(endereco.getComplemento(), "");

	}

}
