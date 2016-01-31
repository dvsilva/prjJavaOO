package dados;

import java.util.Set;
import java.util.TreeSet;

public class Aluno implements Comparable<Aluno>{

	private String matricula;
	private String nome;
	private Set<Turma> conjTurmas;

	public Aluno(String matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.conjTurmas = new TreeSet<Turma>();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean adicionarTurma(Turma t) {
		if (this.conjTurmas.contains(t))
			return false;
		this.conjTurmas.add(t);
		t.adicionarAluno(this);
		return true;
	}

	public boolean removerTurma(Turma t) {
		if (!this.conjTurmas.contains(t))
			return false;
		this.conjTurmas.remove(t);
		t.removerAluno(this);
		return true;

	}

	public int compareTo(Aluno a) {
		return this.nome.compareTo(a.nome);
	}

	@Override
	public String toString() {
		String resultado = this.matricula + "-" + this.nome + " (";
		for (Turma a : this.conjTurmas) {
			resultado += " " + a.getCodigo();
		}
		return resultado + " )";

	}
}
