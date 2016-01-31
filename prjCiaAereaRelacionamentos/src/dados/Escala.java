package dados;

import java.io.Serializable;

public class Escala implements Serializable, Comparable<Escala> {
	//
	//ATRIBUTOS
	//
	private String ordem;
	private String horChegada;
	private String horSaida;
	private Aeroporto aero;
	private Voo voo;
	
	//
	//METODOS
	//
	public Escala(String ordem, String horChegada, String horSaida, Aeroporto a, Voo v) {
		super();
		this.ordem = ordem;
		this.horChegada = horChegada;
		this.horSaida = horSaida;
		this.setAeroporto(a);
		this.setVoo(v);
	}
		
	public String getOrdem() {
		return ordem;
	}
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	public String getHorChegada() {
		return horChegada;
	}
	public void setHorChegada(String horChegada) {
		this.horChegada = horChegada;
	}
	public String getHorSaida() {
		return horSaida;
	}
	public void setHorSaida(String horSaida) {
		this.horSaida = horSaida;
	}

	
	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.ordem, this.horChegada, this.horSaida};
	}
	
	
	public int compareTo(Escala e) {
		return this.ordem.compareTo(e.ordem);
	}

	/**
	 * Implementação do método toString que retorna uma String que descreve o
	 * objeto Aeronave
	 */

	public String toString() {
		// return this.sigla + "-" + this.nome;
		String resultado = this.ordem + "-" + this.horChegada+ "-" + this.horSaida;
		if (this.aero != null)
			resultado += "(" + this.aero.getNome() + ")";
		if (this.voo != null)
			resultado += "(" + this.voo.getCodVoo() + ")";
		return resultado ;
	}
	
	
	public boolean setAeroporto(Aeroporto a) {
		if (this.aero == a)
			return false;
		if (a == null) {
			Aeroporto anterior = this.aero;
			this.aero = null;
			anterior.removerEscala(this);
			return true;
		}
		if (this.aero != null) {
			this.aero.removerEscala(this);
		}
		this.aero = a;
		a.adicionarEscala(this);
		return true;
	}
	
	public boolean setVoo(Voo v) {
		if (this.voo == v)
			return false;
		if (v == null) {
			Voo anterior = this.voo;
			this.voo = null;
			anterior.removerEscala(this);
			return true;
		}
		if (this.voo != null) {
			this.voo.removerEscala(this);
		}
		this.voo = v;
		v.adicionarEscala(this);
		return true;
	}
}

