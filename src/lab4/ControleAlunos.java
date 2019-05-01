package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * É responsavél por representar um controle de alunos 
 * @author Jackson Mateus
 *
 */
public class ControleAlunos {
	/**
	 * Mapa usado para representar os grupos,onde acontece o mapeamendo do
	 * identificador do grupo,que é o nome do grupo,com os dados do grupo 
	 */
	private HashMap<String,Grupo> grupos;
	/**
	 * Mapa usado para representar os alunos,onde acontece o mapeamendo identificador do aluno,
	 * que é a matricula do aluno,com os dados do aluno
	 */
	private HashMap<String, Aluno> alunos;
	/**
	 * Lista usada para representar os alunos que respoderam questoes
	 */
	
	private ArrayList<Aluno> alunosQueResponderam;
	
	/**
	 * Constrói o controle de alunos,iniciando o mapa de grupo,o mapa de aluno e uma 
	 * lista que representa os alunos que responderam questões
	 */
	public ControleAlunos() {
		alunos = new HashMap<>();
		grupos = new HashMap<>();
		alunosQueResponderam = new ArrayList<>();
		
	}
	/**
	 * Retorna uma lista com os alunos que respoderam questões
	 */
	public ArrayList<Aluno> getAlunosQueResponderam() {
		return alunosQueResponderam;
	}
	
	/**
	 * Cadastra alunos no controle,a partir da matricula,nome e curso do aluno,
	 * tambem inicializa o aluno
	 * @param matricula do aluno
	 * @param nome do aluno
	 * @param curso do aluno
	 * @return um booleano,se a matricula desse aluno já foi cadastrada no controle
	 * retorna false,caso contrário retorna true  
	 */
	public boolean cadastraAlunos(String matricula, String nome, String curso) {
		boolean cadastra = true;
		String saida = "";
		if (alunos.containsKey(matricula)) {
			cadastra = false;
		} else {
			alunos.put(matricula, new Aluno(matricula, nome, curso));
		}
		return cadastra;

	}
	/**
	 * Lista os dados do aluno consultado a partir da matricula do aluno
	 * @param matricula do aluno a ser consultado
	 * @return uma String com os dados do aluno consultado
	 */
	public String consultaAluno(String matricula) {
		String saida = "";
		if (alunos.containsKey(matricula)) {
			for (Aluno aluno : alunos.values()) {
				if (aluno.getMatricula().equals(matricula)) {
					saida = "Aluno: "+ aluno.toString();
				}
			}
		} else {
			saida ="ALUNO NÃO CADASTRADO.";
		}
		return saida;
	}
	/**
	 * Cadastra grupos no controle,a partir do nome do grupo,
	 * tambem inicializa o grupo
	 * @param nome do grupo,que representa o id do grupo
	 * @return um booleano,se esse grupo já foi cadastrado no controle
	 * retorna false,caso contrário retorna true  
	 */
	public boolean cadastraGrupo(String nome) {
		nome=nome.toUpperCase();
		boolean cadastra=true;
		if (grupos.containsKey(nome)) {
			cadastra = false;  } 
		
		if (cadastra==true) {
			grupos.put(nome,new Grupo(nome)); }
		
		return cadastra; }
	
	/**
	 * Aloca o aluno em um determinado grupo de estudo
	 * @param matricula do aluno a ser alocado em um grupo de estudo
	 * @param grupo que o aluno vai ser alocado
	 * @return uma String mostrando se o aluno foi alocado no grupo de estudo,ou possiveis
	 * mensagens se houve algum problema na alocação do aluno
	 */
	public String alocarAlunoGrupo(String matricula,String grupo) {
		grupo = grupo.toUpperCase();
		String saida="";
		if  (grupos.containsKey(grupo) && alunos.containsKey(matricula)) {
			grupos.get(grupo).getAdicionaNoGrupo().add(alunos.get(matricula));
			saida="ALUNO ALOCADO!"; } 
		else if (!alunos.containsKey(matricula) && grupos.containsKey(grupo))
				saida="ALUNO NÃO CADASTRADO!";
		else if (!grupos.containsKey(grupo) && alunos.containsKey(matricula))
	    	  saida="GRUPO NÃO CADASTRADO!";
		else if (!alunos.containsKey(matricula) && !grupos.containsKey(grupo)) {
			 saida = "GRUPO E ALUNO NÃO CADASTRADO!";}
		
		return saida;
		}
	/**
	 * Imprime os alunos de um determinado grupo de estudo
	 * @param grupo de alunos que será imprimido
	 * @return uma String com os alunos de um determinado grupo ou uma mensagem mostrando que
	 * o grupo passado como paramentro não foi cadastrado no controle
	 */
	public String imprimirGrupos(String grupo) {
		String grupoEntrada=grupo;
		grupo = grupo.toUpperCase();
		String saida="";
		 if (!grupos.containsKey(grupo)) {
			saida="GRUPO NÃO CADASTRADO";
		}
		else {
			saida+="Alunos do grupo " + grupoEntrada.substring(0, 1).toUpperCase().concat(grupoEntrada.substring(1)) +":" + "\n";
			for(Aluno alunos : grupos.get(grupo).getAdicionaNoGrupo()) {
				saida += "* "+ alunos.toString() + "\n"; }
		}
		return saida;
		}
	/**
	 * Cadastra alunos que responderam questões no quadro
	 * @param matricula do aluno
	 * @return uma mensagem que o aluno foi cadastrado no controle ou 
	 * mostrando que a matricula do aluno passado como parametro não foi cadastrada no sistema
	 */
	public String cadastraAlunosQueResponderam(String matricula) {
		String saida="";
		if (!alunos.containsKey(matricula)) {
			saida = "ALUNO NÃO CADASTRADO!";
		}
		else {
			alunosQueResponderam.add(alunos.get(matricula));
			saida="ALUNO REGISTRADO!"; }
		return saida;
	}
	/**
	 * Imprime todos os alunos que responderam questões no quadro
	 * @return uma String representando os alunos que respoderam questão no quadro
	 */
	public String imprimeAlunosQueRespoderam() {
		String saida="";
		saida="Alunos: \n";
		for (int i=0;i<alunosQueResponderam.size();i++) {
			saida+= i+1 +". "+ alunosQueResponderam.get(i).toString() + "\n"; }
		return saida;
			}
	
	

	
}
	


