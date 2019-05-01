package lab4;

import java.util.HashSet;
/**
 * É responsável por representar um grupo de estudo
 * @author Jackson Matheus
 *
 */
public class Grupo {
	/**
	 * Nome do grupo
	 */
	private String grupo;
	/**
	 * Conjunto de alunos,usado para alocar os alunos em um grupo
	 */
	private HashSet<Aluno>adicionaNoGrupo;
		
	/**
	 * Inicia um grupo a partir do nome do grupo,tambem é iniciado o conjunto de
	 * alunos que seram alocados no grupo,
	 * dependendo do conteudo da variavél recebida pode haver exceções
	 * @param nome do grupo
	 */
	public Grupo(String grupo) {
		this.grupo = grupo;
		adicionaNoGrupo = new HashSet<>();
		if (grupo==null)
			throw new NullPointerException("Grupo nulo");
		else if(grupo.trim().equals(""))
			throw new IllegalArgumentException("Parametro Inválido"); }
	
	/**
	 * Retorna o conjunto de alunos do grupo
	 */
	public HashSet<Aluno> getAdicionaNoGrupo() {
		return adicionaNoGrupo;
	}

	/**
	 * Retorna o nome do grupo
	 */
	public String getGrupo() {
		return grupo;
	}
	/**
	 * Metodo Hashcode que retorna o codigo hash do objeto grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		return result;
	}
	/**
	 * Metodo equals,usado para comparar se dois grupos
	 * são iguais,dois grupos são iguais pelo nome do grupo
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}

	/**
	 * Retorna uma representação textual do grupo com o nome do grupo
	 */
	@Override
	public String toString() {
		return "Alunos do grupo " + grupo +":";
	}
	
	


}
