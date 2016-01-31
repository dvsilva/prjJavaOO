package dados;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Aeroporto implements Serializable, Comparable<Aeroporto>{
	//
	//ATRIBUTOS
	//
	private String codAeroporto;
	private String nome;
	private String endereco;
	private String telefones;
	private Set<Voo> conjVooSai;
	private Set<Voo> conjVooChega;
	private Collection<Escala> conjEscalas;
	//
	//METODOS
	//
	public Aeroporto(String codAeroporto, String nome, String endereco, String telefones) {
		super();
		this.codAeroporto = codAeroporto;
		this.nome = nome;
		this.endereco = endereco;
		this.telefones = telefones;
		this.conjVooSai = new TreeSet<Voo>();
		this.conjVooChega = new TreeSet<Voo>();
		this.conjEscalas = new TreeSet<Escala>();
	}

	public String getCodAeroporto() {
		return codAeroporto;
	}

	public void setCodAeroporto(String codAeroporto) {
		this.codAeroporto = codAeroporto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}
	
	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.codAeroporto, this.nome, this.endereco, this.telefones};
	}
	
	public boolean adicionarVooSai(Voo vs) {
		if (this.conjVooSai.contains(vs))
			return false;
		this.conjVooSai.add(vs);
		vs.setAeroportoSai(this);
		return true;
	}

	public boolean removerVooSai(Voo vs) {
		if (!this.conjVooSai.contains(vs))
			return false;
		this.conjVooSai.remove(vs);
		vs.setAeroportoSai(null);
		return true;
		
	}
	
	@Override
	public int compareTo(Aeroporto a) {
		return this.codAeroporto.compareTo(a.codAeroporto);
	}

	@Override
	public String toString() {
		String resultado = this.codAeroporto + "-" + this.nome + "-" + this.endereco + "-" + this.telefones;
		for (Voo vs : this.conjVooSai) 
			resultado += "(" + vs.getCodVoo() + ")";
		for (Voo vc : this.conjVooChega) 
			resultado += "(" + vc.getCodVoo() + ")";
		for (Escala e : this.conjEscalas)
			resultado += "(" + e.getOrdem() + ")";
		return resultado;
	}
	
	public boolean adicionarVooChega(Voo vc) {
		if (this.conjVooChega.contains(vc))
			return false;
		this.conjVooChega.add(vc);
		vc.setAeroportoChega(this);
		return true;
	}

	public boolean removerVooChega(Voo vc) {
		if (!this.conjVooChega.contains(vc))
			return false;
		this.conjVooChega.remove(vc);
		vc.setAeroportoChega(null);
		return true;
		
	}
	
	public boolean adicionarEscala(Escala e) {
		if (this.conjEscalas.contains(e))
			return false;
		this.conjEscalas.add(e);
		e.setAeroporto(this);
		return true;
	}

	public boolean removerEscala(Escala e) {
		if (!this.conjEscalas.contains(e))
			return false;
		this.conjEscalas.remove(e);
		e.setAeroporto(null);
		return true;
	}
	
}
	

