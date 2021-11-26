package principal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class UsuarioTest {
    @Test
	void testGetNome() {
		Usuario usuario = new Usuario("Nicolas Bitenca", 18,"(51) 98454-5458","Jack@yahoo.com");

		assertEquals(usuario.getNome(), "Nicolas Bitenca");
		assertFalse(usuario.getNome().equals("Avril"));
	}

	@Test
	void testGetIdade() {
		Usuario usuario = new Usuario("Nicolas Bitenca", 18,"(51) 98454-5458","Jack@yahoo.com");

		assertEquals(usuario.getIdade(), 18);
		assertFalse(usuario.getIdade().equals(30));
	}

	@Test
	void testGetTelefone() {
		Usuario usuario = new Usuario("Nicolas Bitenca", 18,"(51) 98454-5458","Jack@yahoo.com");

		assertEquals(usuario.getTelefone(), "(51) 98454-5458");
		assertFalse(usuario.getTelefone().equals("(51) 99999-9999"));
	}

	@Test
	void testGetEmail() {
		Usuario usuario = new Usuario("Nicolas Bitenca", 18,"(51) 98454-5458","Jack@yahoo.com");

		assertEquals(usuario.getEmail(), "Jack@yahoo.com");
		assertFalse(usuario.getEmail().equals("wrong@email.com"));

	}
}
