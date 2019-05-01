package lab4Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.Grupo;

class GrupoTest {
	private Grupo grupo,grupo1,grupo2;
	
	@BeforeEach
	void criaGrupo() {
		grupo=new Grupo("listas");
		grupo1=new Grupo("listas");
		grupo2=new Grupo("lab");  }
	
	@Test
	void testGrupo() {
		assertEquals(grupo.getGrupo(),this.grupo1.getGrupo()); }

	@Test
	void testEqualsObject() {
		assertTrue(this.grupo.equals(grupo1));
		assertFalse(this.grupo.equals(grupo2)); }

	
	@Test
	void testHashCode() {
		assertTrue(this.grupo.hashCode()==this.grupo1.hashCode());
		assertFalse(this.grupo.hashCode()==this.grupo2.hashCode());
	}
	@Test
	void testToString() {
		assertEquals("Alunos do grupo listas:",grupo.toString());
		}
	@Test
	void testNomeGrupoNull() {
		try {
			Grupo grupoInvalido = new Grupo(null);
		} catch (NullPointerException npe ) {
		} }
	@Test
	void testNomeGrupo() {
		try {
			Grupo grupoInvalio = new Grupo("");
		} catch (IllegalArgumentException iae) {
			} }
	
}


