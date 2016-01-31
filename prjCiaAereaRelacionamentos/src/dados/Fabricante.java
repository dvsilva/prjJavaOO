package dados;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

public class Fabricante implements Serializable /* ,Tabelavel */, Comparable<Fabricante> {	
	//
	// ATRIBUTOS
	//
	private String nome;
	private String telefone;
	private Collection<Modelo> conjModelos;
	
	//
	// MÉTODOS
	//
	public Fabricante(String nome, String telefone) {
		super();
		this.telefone = telefone;
		this.nome = nome;
		this.conjModelos = new TreeSet<Modelo>();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.nome, this.telefone};
	}	
	
	public boolean adicionarModelo (Modelo m) {
		if (this.conjModelos.contains(m))
			return false;
		this.conjModelos.add(m);
		m.setFabricante(this);
		return true;
	}

	public boolean removerModelo(Modelo m) {
		if (!this.conjModelos.contains(m))
			return false;
		this.conjModelos.remove(m);
		m.setFabricante(null);
		return true;
	}

	@Override
	public int compareTo(Fabricante f) {
		return this.nome.compareTo(f.nome);
	}

	/**
	 * Implementação do método toString que retorna uma String que descreve o
	 * objeto Aeronave
	 */

	public String toString() {
		String resultado = this.nome + "-" + this.telefone;
		for (Modelo m : this.conjModelos)
			resultado += "(" + m.getNome() + ")" ;
		return resultado;
	}
}
