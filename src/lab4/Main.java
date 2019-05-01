package lab4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ControleAlunos controleAlunos = new ControleAlunos();
		
		while(true) {
			System.out.println("(C)adastrar Aluno");
			System.out.println("(E)xibir Aluno");
			System.out.println("(N)ovo Grupo");
			System.out.println("(A)locar Aluno no Grupo e imprimir Grupos");
			System.out.println("(R)egistrar Aluno que Respondeu");
			System.out.println("(I)mprimir Alunos que Responderam");
			System.out.println("(O)ra, vamos fechar o programa!");
			System.out.println();
			System.out.print("Opção>");
			String opcao = sc.next().toUpperCase().trim();
			
			switch(opcao) {
			case("C"):
				System.out.print("Matricula: ");
				sc.nextLine();
				String matricula = sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				System.out.println();
				if (controleAlunos.cadastraAlunos(matricula, nome, curso)) {
					controleAlunos.cadastraAlunos(matricula, nome, curso);
					System.out.println("CADASTRO REALIZADO!"); }
				else {
					System.out.println("MATRICULA JÁ CADASTRADA!"); }
				System.out.println();
				break;
	
			case("E"):
				System.out.print("Matricula: ");
				sc.nextLine();
				matricula = sc.nextLine();
				System.out.println(controleAlunos.consultaAluno(matricula));
				System.out.println();
				break;
			
			case("N"):
				System.out.print("Grupo: ");
				sc.nextLine();
				String grupo = sc.nextLine();
				if (controleAlunos.cadastraGrupo(grupo)){
					System.out.println("CADASTRO REALIZADO!");
				}
				else {
					System.out.println("GRUPO JÁ CADASTRADO"); }
				System.out.println();
				break;
			case("A"):
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				char resposta = sc.next().charAt(0);
				if (resposta =='A' || resposta == 'a') {
				System.out.print("Matricula: ");
				sc.nextLine();
				matricula = sc.nextLine();
				System.out.print("Grupo: ");
				grupo = sc.nextLine();
				System.out.println(controleAlunos.alocarAlunoGrupo(matricula, grupo)); }
				else if (resposta=='I' || resposta=='i') {
					System.out.print("Grupo: ");
					sc.nextLine();
					grupo = sc.nextLine();
					System.out.println();
					System.out.println(controleAlunos.imprimirGrupos(grupo));
				}
				System.out.println();
				break;
				case("R"):
					System.out.print("Matricula: ");
					sc.nextLine();
					matricula = sc.nextLine();
					System.out.println(controleAlunos.cadastraAlunosQueResponderam(matricula));
					System.out.println();
					break;
				case("I"):
					if (controleAlunos.getAlunosQueResponderam().size()==0)
						System.out.println("NENHUM ALUNO CADASTRADO RESPONDEU! \n");
					else {
					System.out.println(controleAlunos.imprimeAlunosQueRespoderam());
					System.out.println();}
					break;
				case("O"):
					System.exit(0);
				default:
					System.out.println("ENTRADA INVÁLIDA");
					System.out.println();
					break;
					
					

					
					
				
					
					
					}			
	}
			
}

}


