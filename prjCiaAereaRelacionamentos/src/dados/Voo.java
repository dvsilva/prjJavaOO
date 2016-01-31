package dados;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
//import controle.Tabelavel;

public class Voo implements Serializable/*,Tabelavel */, Comparable<Voo>{	
	//
	// ATRIBUTOS
	//
	private String codVoo;
	private String horaPartida;
	private String horaChegada;
	private String dataRealizacao;
	//Relacionamento unário com Aeronave
	private Aeronave aero;
	
	private Set<Assento> conjAssentos;
	private Aeroporto aeroportoSai;
	private Aeroporto aeroportoChega;
	private Collection<Escala> conjEscalas;
	
	//
	// MÉTODOS
	//
	public Voo(String codVoo, String horaPartida, String horaChegada, String dataRealizacao, Aeronave a, Aeroporto as, Aeroporto ac) {
		super();
		this.codVoo = codVoo;
		this.horaPartida = horaPartida;
		this.horaChegada = horaChegada;
		this.dataRealizacao = dataRealizacao;
		this.setAeronave(a);
		this.conjAssentos = new TreeSet<Assento>();
		this.setAeroportoSai(as);
		this.setAeroportoChega(ac);
		this.conjEscalas = new TreeSet<Escala>();
	}

	public String getCodVoo() {
		return codVoo;
	}

	public void setCodVoo(String codVoo) {
		this.codVoo = codVoo;
	}

	public String getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public String getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}


	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.codVoo,this.horaPartida, this.horaChegada, this.dataRealizacao };
	}	

	public boolean setAeronave(Aeronave a){
		if (this.aero == a)
			return false;
		if (a == null){
			Aeronave anterior = this.aero;
			this.aero = null;
			anterior.removerVoo(this);
			return true;
		}
		if (this.aero != null){
			this.aero.removerVoo(this);
		}
		this.aero = a;
		a.adicionarVoo(this);
		return true;
	}
	
	public int compareTo(Voo v){
		return this.codVoo.compareTo(v.codVoo);
	}
	
	
	/** 
	 * Implementação do método toString que retorna uma String
	 * que descreve o objeto Voo
	 */
	
	
	public String toString(){
		String resultado =  this.codVoo + "-" + this.dataRealizacao + "-" + this.horaChegada + "-" + this.horaPartida;
		if (this.aero != null)
			resultado += "(" + this.aero.getNome() + ")";
		if (this.aeroportoSai != null)
			resultado += "(" + this.aeroportoSai.getNome() + ")";
		if (this.aeroportoChega != null)
			resultado += "(" + this.aeroportoChega.getNome() + ")";
		for (Assento a : this.conjAssentos)
			resultado += "(" + a.getAssentoNum() + ")";
		for (Escala e : this.conjEscalas)
			resultado += "(" + e.getOrdem() + ")";
		return resultado;
		
		
	}
	
	public boolean adicionarAssento(Assento a) {
		if (this.conjAssentos.contains(a))
			return false;
		this.conjAssentos.add(a);
		a.setVoo(this);
		return true;
	}

	public boolean removerAssento(Assento a) {
		if (!this.conjAssentos.contains(a))
			return false;
		this.conjAssentos.remove(a);
		a.setVoo(null);
		return true;
	}
	
	public boolean setAeroportoSai(Aeroporto as) {
		if (this.aeroportoSai == as)
			return false;
		if (as == null) {
			Aeroporto anterior = this.aeroportoSai;
			this.aeroportoSai = null;
			anterior.removerVooSai(this);
			return true;
		}
		if (this.aeroportoSai != null) {
			this.aeroportoSai.removerVooSai(this);
		}
		this.aeroportoSai = as;
		as.adicionarVooSai(this);
		return true;
	}
	
	public boolean setAeroportoChega(Aeroporto ac) {
		if (this.aeroportoChega == ac)
			return false;
		if (ac == null) {
			Aeroporto anterior = this.aeroportoChega;
			this.aeroportoChega = null;
			anterior.removerVooChega(this);
			return true;
		}
		if (this.aeroportoChega != null) {
			this.aeroportoChega.removerVooChega(this);
		}
		this.aeroportoChega = ac;
		ac.adicionarVooChega(this);
		return true;
	}
	
	public boolean adicionarEscala(Escala e) {
		if (this.conjEscalas.contains(e))
			return false;
		this.conjEscalas.add(e);
		e.setVoo(this);
		return true;
	}

	public boolean removerEscala(Escala e) {
		if (!this.conjEscalas.contains(e))
			return false;
		this.conjEscalas.remove(e);
		e.setVoo(null);
		return true;
	}
	
}



