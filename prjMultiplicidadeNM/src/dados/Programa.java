package dados;

public class Programa {

	
	public static void main(String[] args) {
		
		Turma t1 = new Turma("EIN232-21","SEX N2-N5");
		Turma t2 = new Turma("EIN349-20","TER N2-N5");
		Aluno a1 = new Aluno("5305123","José");
		Aluno a2 = new Aluno("5305544","Beatriz");
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(a1);
		System.out.println(a2);
		
		a1.adicionarTurma(t1);
		a1.adicionarTurma(t2);
		a2.adicionarTurma(t1);
		a2.adicionarTurma(t2);
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(a1);
		System.out.println(a2);
		
		a1.removerTurma(t1);
		a2.removerTurma(t2);
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(a1);
		System.out.println(a2);
	}

}
