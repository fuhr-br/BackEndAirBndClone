package principal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UsuarioTest {
    @Test
	void testGetNome() {
		Usuario usuario = new Usuario("Nicolas Bitenca",18,"(51) 98454-5458","Jack@yahoo.com");

		assertEquals(usuario.getNome(), "Nicolas Bitenca");

	}
}
