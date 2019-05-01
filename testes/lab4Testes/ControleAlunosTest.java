package lab4Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.ControleAlunos;

class ControleAlunosTest {
	private ControleAlunos controleAlunos;
	
	@BeforeEach
	public void criaControleAlunos() {
		controleAlunos = new ControleAlunos(); }
	@Test
	void testGetAlunosQueResponderam() {
		assertTrue(this.controleAlunos.getAlunosQueResponderam().size()==0);
		this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes Silva", "CC");
		this.controleAlunos.cadastraAlunosQueResponderam("250");
		assertTrue(this.controleAlunos.getAlunosQueResponderam().size()==1);
	}

	@Test
	void testCadastraAlunos() {
		assertTrue(this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes Silva", "CC"));
		assertFalse(this.controleAlunos.cadastraAlunos("250", "Jackson", "CC"));
		assertTrue(this.controleAlunos.cadastraAlunos("251", "Gabriel Reyes Silva", "CC")); }

	@Test
	void testConsultaAluno() {
		this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes", "CC");
		this.controleAlunos.cadastraAlunos("251", "Lucas Lima", "EE");
		assertEquals("Aluno: 250 - Gabriel Reyes - CC",this.controleAlunos.consultaAluno("250"));
		assertEquals("Aluno: 251 - Lucas Lima - EE",this.controleAlunos.consultaAluno("251")); 
		assertEquals("ALUNO NÃO CADASTRADO.",this.controleAlunos.consultaAluno("252"));
	}
	@Test
	void testCadastraGrupo() {
		assertTrue(this.controleAlunos.cadastraGrupo("listas"));
		assertFalse(this.controleAlunos.cadastraGrupo("Listas"));
		assertFalse(this.controleAlunos.cadastraGrupo("listas"));
		assertTrue(this.controleAlunos.cadastraGrupo("labs")); }
	
	@Test
	void testAlocarAlunoGrupo() {
		this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes Silva", "CC");
		this.controleAlunos.cadastraAlunos("251", "Lucas Lima", "EE");
		this.controleAlunos.cadastraGrupo("listas");
		assertEquals("ALUNO ALOCADO!",this.controleAlunos.alocarAlunoGrupo("250","listas"));
		assertEquals("ALUNO ALOCADO!",this.controleAlunos.alocarAlunoGrupo("251","listas"));
		assertEquals("ALUNO NÃO CADASTRADO!",this.controleAlunos.alocarAlunoGrupo("252","listas"));
		assertEquals("GRUPO NÃO CADASTRADO!",this.controleAlunos.alocarAlunoGrupo("250","labs"));
		assertEquals("GRUPO E ALUNO NÃO CADASTRADO!",this.controleAlunos.alocarAlunoGrupo("252","labs")); }

	@Test
	void testImprimirGrupos() {
		this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes", "CC");
		this.controleAlunos.cadastraAlunos("251", "Lucas Lima", "EE");
		this.controleAlunos.cadastraGrupo("listas");
		this.controleAlunos.alocarAlunoGrupo("250", "listas");
		this.controleAlunos.alocarAlunoGrupo("251", "listas");
		assertEquals("Alunos do grupo Listas:\n* 250 - Gabriel Reyes - CC\n* 251 - Lucas Lima - EE\n",this.controleAlunos.imprimirGrupos("listas"));
		assertEquals("GRUPO NÃO CADASTRADO",this.controleAlunos.imprimirGrupos("labs")); }

	@Test
	void testCadastraAlunosQueResponderam() {
		this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes Silva", "CC");
		assertEquals("ALUNO REGISTRADO!",this.controleAlunos.cadastraAlunosQueResponderam("250"));
		assertEquals("ALUNO NÃO CADASTRADO!",this.controleAlunos.cadastraAlunosQueResponderam("251")); }

	@Test
	void testImprimeAlunosQueRespoderam() {
		this.controleAlunos.cadastraAlunos("250", "Gabriel Reyes", "CC");
		this.controleAlunos.cadastraAlunos("251", "Lucas Lima", "EE");
		this.controleAlunos.cadastraAlunosQueResponderam("250");
		this.controleAlunos.cadastraAlunosQueResponderam("251");
		assertEquals("Alunos: \n1. 250 - Gabriel Reyes - CC\n2. 251 - Lucas Lima - EE\n",this.controleAlunos.imprimeAlunosQueRespoderam());

		
	}

}
