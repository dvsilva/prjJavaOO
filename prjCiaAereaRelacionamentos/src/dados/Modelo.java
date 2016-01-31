package dados;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

public class Modelo implements Serializable/* ,Tabelavel */,
		Comparable<Modelo> {
	//
	// ATRIBUTOS
	//

	private String nome;
	private String numMaxLugar;
	private String autonomiaVoo;
	private String capacidadeTanque;
	private Collection<Aeronave> conjAeronaves;
	private Fabricante fab;

	//
	// MÉTODOS
	//

	public Modelo(String nome, String numMaxLugar, String autonomiaVoo,
			String capacidadeTanque, Fabricante f) {   //problema aqui atributos invertidos
		super();
		this.numMaxLugar = numMaxLugar;
		this.autonomiaVoo = autonomiaVoo;
		this.capacidadeTanque = capacidadeTanque;
		this.nome = nome;
		this.conjAeronaves = new TreeSet<Aeronave>();
		this.setFabricante(f);
	}

	public String getNumMaxLugar() {
		return numMaxLugar;
	}

	public void setNumMaxLugar(String numMaxLugar) {
		this.numMaxLugar = numMaxLugar;
	}

	public String getAutonomiaVoo() {
		return autonomiaVoo;
	}

	public void setAutonomiaVoo(String autonomiaVoo) {
		this.autonomiaVoo = autonomiaVoo;
	}

	public String getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(String capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
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
		return new Object[] { this.nome, this.numMaxLugar, this.autonomiaVoo,
				this.capacidadeTanque };
	}

	public boolean adicionarAeronave(Aeronave a) {
		if (this.conjAeronaves.contains(a))
			return false;
		this.conjAeronaves.add(a);
		a.setModelo(this);
		return true;
	}

	public boolean removerAeronave(Aeronave a) {
		if (!this.conjAeronaves.contains(a))
			return false;
		this.conjAeronaves.remove(a);
		a.setModelo(null);
		return true;
	}

	@Override
	public int compareTo(Modelo o) {
		return this.nome.compareTo(o.nome);
	}

	/**
	 * Implementação do método toString que retorna uma String que descreve o
	 * objeto Aeronave
	 */

	public String toString() {
		String resultado = this.nome + "-" + this.numMaxLugar + "-"
				+ this.autonomiaVoo + "-" + this.capacidadeTanque ;
		if (this.fab != null)
			resultado += "(" + this.fab.getNome() + ")";
		for (Aeronave a : this.conjAeronaves)
			resultado += "(" + a.getNome()+ ")";
		return resultado ;
	}

	public boolean setFabricante(Fabricante f) {
		if (this.fab == f)
			return false;
		if (f == null) {
			Fabricante anterior = this.fab;
			this.fab = null;
			anterior.removerModelo(this);
			return true;
		}
		if (this.fab != null) {
			this.fab.removerModelo(this);
		}
		this.fab = f;
		f.adicionarModelo(this);
		return true;
	}

}
