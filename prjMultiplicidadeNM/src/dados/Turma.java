package dados;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Turma implements Comparable<Turma>{
	
	private String codigo;
	private String horario;
	private Set<Aluno> conjAlunos;
	
	public Turma(String codigo, String horario) {
		super();
		this.codigo = codigo;
		this.horario = horario;
		this.conjAlunos = new TreeSet<Aluno>();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public boolean adicionarAluno(Aluno a) {
		if (this.conjAlunos.contains(a))
			return false;
		this.conjAlunos.add(a);
		a.adicionarTurma(this);
		return true;
	}
	
	public boolean removerAluno(Aluno a) {
		if (!this.conjAlunos.contains(a))
			return false;
		this.conjAlunos.remove(a);
		a.removerTurma(this);
		return true;
	}

	@Override
	public int compareTo(Turma t) {
		return this.codigo.compareTo(t.codigo);
	}

	@Override
	public String toString() {
		String resultado = this.codigo + "-" + this.horario + " (";
		for (Aluno a : this.conjAlunos) {
			resultado += " " + a.getNome();
		}
		return resultado + " )";
	}
	
}
