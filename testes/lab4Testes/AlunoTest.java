package lab4Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.Aluno;

class AlunoTest {
	private Aluno aluno,aluno2,aluno3,aluno4;
	@BeforeEach
	void criaAluno() {
		aluno = new Aluno("250","Jackson Cunha","CC");
		aluno2 = new Aluno("250","Gustavo","EE");
		aluno3 = new Aluno("251","Jackson Cunha","CC");
		aluno4 = new Aluno("252","Jackson Cunha","EE");
	}
	@Test
	void testAluno() {
		Aluno aluno1 = new Aluno("250","Jackson","CC");
		assertEquals(this.aluno.getCurso(),aluno1.getCurso());
		assertEquals(this.aluno.getMatricula(),aluno1.getMatricula());
		assertEquals(this.aluno.getCurso(),aluno1.getCurso()); }

	
	@Test
	void testEqualsObject() {
		assertTrue(this.aluno.equals(this.aluno2));
		assertFalse(this.aluno.equals(this.aluno3));
		assertFalse(this.aluno.equals(aluno4));
		assertFalse(this.aluno.equals(null));	}

	@Test
	void testHashCodeObject() {
		assertTrue(this.aluno.hashCode()==this.aluno2.hashCode());
		assertFalse(this.aluno.hashCode()==this.aluno3.hashCode());
		assertFalse(this.aluno.hashCode()==this.aluno3.hashCode()); }
	@Test
	void testToString() {
		assertEquals("250 - Jackson Cunha - CC",aluno.toString());
	}
	@Test
	void testMatriculaNull() {
		try {
			Aluno alunoInvalido = new Aluno(null,"Jackson","CC");
		} catch(NullPointerException npe) {
		} }
	@Test
	void testNomeNull() {
		try {
			Aluno alunoInvalido = new Aluno("250",null,"CC");
		} catch(NullPointerException npe) {
		} }
	@Test
	void testCursoNull() {
		try {
			Aluno alunoInvalido = new Aluno("250","Jackson",null);
		} catch(NullPointerException npe) {
		} }
	
	@Test
	void testMatricula() {
		try {
			Aluno alunoInvalido = new Aluno("","Jackson","CC");
		} catch(IllegalArgumentException iae) {
		} }
	@Test
	
	void testNome() {
		try {
			Aluno alunoInvalido = new Aluno("250","","CC");
		} catch(IllegalArgumentException iae) {
		} }
	@Test
	void testCurso() {
		try {
			Aluno alunoInvalido = new Aluno("250","Jackson","");
		} catch(IllegalArgumentException iae) {
		} }
	
	
	
	
	
	
	
	






}



	



	
	
	
	
	
	
	
	


