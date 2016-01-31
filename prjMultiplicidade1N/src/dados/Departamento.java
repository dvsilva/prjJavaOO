package dados;

import java.util.Collection;
import java.util.TreeSet;

public class Departamento implements Comparable<Departamento> {
	
	private String sigla;
	private String nome;
	private Collection<Empregado> conjEmpregados;
		
	public Departamento(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.conjEmpregados = new TreeSet<Empregado>();
	}


	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean adicionarEmpregado(Empregado e){
		if(this.conjEmpregados.contains(e))
			return false;
		this.conjEmpregados.add(e);
		e.setDepto(this);
		return true;
	}

	public boolean removerEmpregado(Empregado e){
		if(!this.conjEmpregados.contains(e))
			return false;
		this.conjEmpregados.remove(e);
		e.setDepto(null);
		return true;
	}
	
	public int compareTo(Departamento d){
		return this.nome.compareTo(d.nome);
			}
	
	public String toString(){
		//return this.sigla + "-" + this.nome;
		String resultado = this.sigla+ " - " + this.nome + "(";
		for (Empregado e : this.conjEmpregados)
			resultado += " " + e.getNome();
		return resultado + " )";
		//return resultado;
	}
}
