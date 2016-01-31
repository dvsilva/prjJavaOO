package dados;

import java.io.Serializable;
import controle.Tabelavel;

public class Empregado implements Serializable, Tabelavel, Comparable<Empregado> {
	//
	// ATRIBUTOS
	//
	private String cpf;
	private String nome;
	private Departamento depto;
	
	//
	// MÉTODOS
	//
	public Empregado(String cpf, String nome, Departamento d) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.depto = d;
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

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}	

	/** 
	 * Implementação do método toString que retorna uma String
	 * que descreve o objeto Empregado
	 */
	public String toString() {
		return this.cpf + "-" + this.nome;
	}

	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.cpf, this.nome, this.depto.getNome()};
	}

	/**
	 * Método utilizado para colocar os empregados em ordem 
	 */
	public int compareTo(Empregado d) {
		return this.nome.compareTo(d.nome);
	}
}