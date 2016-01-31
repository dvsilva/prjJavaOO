package dados;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Passageiro implements Serializable, Comparable<Passageiro>{
	//
	//ATRIBUTOS
	//
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private Set<Assento> conjAssentos;
	//
	//METODOS
	//
	public Passageiro(String cpf, String nome, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.conjAssentos = new TreeSet<Assento>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return new Object[]{this.cpf, this.nome, this.endereco, this.telefone};
	}
	
	public boolean adicionarAssento(Assento a) {
		if (this.conjAssentos.contains(a))
			return false;
		this.conjAssentos.add(a);
		a.setPass(this);
		return true;
	}

	public boolean removerAssento(Assento a) {
		if (!this.conjAssentos.contains(a))
			return false;
		this.conjAssentos.remove(a);
		a.setPass(null);
		return true;
	}

	public int compareTo(Passageiro p) {
		return this.cpf.compareTo(p.cpf);
	}

public String toString() {
		//return this.sigla + "-" + this.nome;
		String resultado = this.cpf + "-" + this.nome +  "-" + this.endereco +  "-" + this.telefone;
		for (Assento a : this.conjAssentos)
			resultado +=  "(" + a.getAssentoNum()+  ")";
			return resultado;
	}
}
