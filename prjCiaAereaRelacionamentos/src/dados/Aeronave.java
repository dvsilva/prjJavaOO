package dados;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

//import controle.Tabelavel;

public class Aeronave implements Serializable/* ,Tabelavel */,Comparable<Aeronave> {
	//
	// ATRIBUTOS
	//
	private String nome;
	private Collection<Voo> conjVoos;
	private Modelo mod;

	//
	// MÉTODOS
	//
	public Aeronave(String nome, Modelo m) {
		super();
		this.nome = nome;
		this.conjVoos = new TreeSet<Voo>();
		this.setModelo(m);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna um array de Objects com os estados dos atributos dos objetos
	 * 
	 * @return
	 */
	public Object[] getData() {
		return new Object[] { this.nome };

	}

	public boolean adicionarVoo(Voo v) {
		if (this.conjVoos.contains(v))
			return false;
		this.conjVoos.add(v);
		v.setAeronave(this);
		return true;
	}

	public boolean removerVoo(Voo v) {
		if (!this.conjVoos.contains(v))
			return false;
		this.conjVoos.remove(v);
		v.setAeronave(null);
		return true;
	}

	public int compareTo(Aeronave a) {
		return this.nome.compareTo(a.nome);
	}

	/**
	 * Implementação do método toString que retorna uma String que descreve o
	 * objeto Aeronave
	 */

	public String toString() {
		// return this.sigla + "-" + this.nome;
		String resultado = this.nome;
		if (this.mod != null)
			resultado += "(" + this.mod.getNome() + ")";
		for (Voo v : this.conjVoos)
			resultado += "(" + v.getCodVoo() + ")" ;
		return resultado;
	}

	public boolean setModelo(Modelo m) {
		if (this.mod == m)
			return false;
		if (m == null) {
			Modelo anterior = this.mod;
			this.mod = null;
			anterior.removerAeronave(this);
			return true;
		}
		if (this.mod != null) {
			this.mod.removerAeronave(this);
		}
		this.mod = m;
		m.adicionarAeronave(this);
		return true;
	}
}
