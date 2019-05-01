package lab4;

/**
 * É responsavél por representar um aluno 
 * @author Jackson Mateus
 *
 */
public class Aluno {
	/**
	 * Matricula do aluno
	 */
	private String matricula;
	/**
	 * Nome do aluno
	 */
	private String nome;
	/**
	 * Curso do aluno
	 */
	private String curso;
	
	/**
	 * Inicia um aluno a partir da matricula,nome,curso.
	 * Dependendo do conteudo da variavél pode haver exceções 
	 * @param matricula do aluno
	 * @param nome do aluno
	 * @param curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula ==null)
			throw new NullPointerException("Matricula nula");
		else if(matricula.trim().equals(""))
			throw new IllegalArgumentException("Parametro inválido");
		if (nome==null) 
			throw new NullPointerException("Nome nulo");
		else if(nome.trim().equals("")) 
			throw new IllegalArgumentException("Parametro inválido");
		if (curso ==null)
			throw new NullPointerException("curso nulo");
		else if (curso.trim().equals(""))
			throw new IllegalArgumentException("Parametro inválido");
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso; }
	
	/**
	 * Retorna a matricula do aluno
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * Retorna o nome do aluno
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Retorna o curso do aluno
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Metodo Hashcode que retorna o codigo hash do objeto aluno
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Metodo equals,usado para comparar se dois alunos
	 * são iguais,dois alunos são iguais pela matricula
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Retorna uma representação textual do aluno com matricula,nome e
	 * curso do aluno
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome +  " - " + curso;
	}
	
	}

	
	
	
	
	
	


