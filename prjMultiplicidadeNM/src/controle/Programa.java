package controle;

import dados.Aluno;
import dados.Turma;

public class Programa {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("5305564", "Reinaldo");
		Aluno a2 = new Aluno("5305615", "Victor");
		Aluno a3 = new Aluno("5305024", "Carlos");
		Aluno a4 = new Aluno("5305028", "Alessandro");
		Aluno a5 = new Aluno("5453425", "João");
		Aluno a6 = new Aluno("5323359", "Priscila");
		Aluno a7 = new Aluno("5454534", "Lorrayne");
		Aluno a8 = new Aluno("5354331", "André");
		Aluno a9 = new Aluno("5387677", "Jonathan");
		Aluno a10 = new Aluno("5376569", "Gabriel");

		Turma t1 = new Turma("SI", "N2-N3-N4");
		Turma t2 = new Turma("ADM", "N1-N2-N5");
		Turma t3 = new Turma("ENG", "N1-N2-N3");

		// Mostra as turmas
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);

		// Mostra os Alunos
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
		System.out.println(a6);
		System.out.println(a7);
		System.out.println(a8);
		System.out.println(a9);
		System.out.println(a10);
		
		//Como o relacionamento é de muitos para muitos logo um 
		//o aluno pode estar alocado em varias turmas e vice e versa.
		t1.adicionarAluno(a1);
		t1.adicionarAluno(a3);
		t1.adicionarAluno(a6);
		t1.adicionarAluno(a8);
		t1.adicionarAluno(a10);
		t2.adicionarAluno(a2);
		t2.adicionarAluno(a3);
		t2.adicionarAluno(a5);
		t2.adicionarAluno(a7);
		t3.adicionarAluno(a3);

		// Mostra as turmas
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);

		t2.removerAluno(a2);
		t2.removerAluno(a5);
		t2.removerAluno(a7);
		t2.removerAluno(a4);

		// Mostra as turmas
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);

		

	}

}
