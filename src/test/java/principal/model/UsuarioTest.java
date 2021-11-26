package principal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class UsuarioTest {
    @Test
	void testGetNome() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		assertEquals(usuario.getNome(), "William Wallace");
		assertFalse(usuario.getNome().equals("Avril"));
	}

	@Test
	void testSetNome() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		usuario.setNome("Jonas");
		assertEquals(usuario.getNome(), "Jonas");
	}

	@Test
	void testGetIdade() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		assertEquals(usuario.getIdade(), 18);
		assertFalse(usuario.getIdade().equals(30));
	}

	@Test
	void testSetIdade() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		usuario.setIdade(50);
		assertEquals(usuario.getIdade(), 50);
	}

	@Test
	void testGetTelefone() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		assertEquals(usuario.getTelefone(), "(51) 98454-5458");
		assertFalse(usuario.getTelefone().equals("(51) 99999-9999"));
	}
	
	@Test
	void testSetTelefone() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		usuario.setTelefone("(51) 91234-5678");
		assertEquals(usuario.getTelefone(), "(51) 91234-5678");
	}

	@Test
	void testGetEmail() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		assertEquals(usuario.getEmail(), "will@email.com");
		assertFalse(usuario.getEmail().equals("wrong@email.com"));

	}

	@Test
	void testSetEmail() {
		Usuario usuario = new Usuario("William Wallace", 18, "(51) 98454-5458","will@email.com");

		usuario.setEmail("marcus@email.com");
		assertEquals(usuario.getEmail(), "marcus@email.com");

	}
}
