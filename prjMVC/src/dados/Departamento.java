package dados;

import java.io.Serializable;
import controle.Tabelavel;

/**
 * Implementa a classe Departamento que tem o "implements Serializable"
 * para realizar o processo de serialização e o "implements Tabelavel"
 * para informar que os objetos poderão ser exibidos em uma 
 * tabela de interface
 * @author Alessandro Cerqueira
 *
 */
public class Departamento implements Serializable, Tabelavel, Comparable<Departamento> {	
	//
	// ATRIBUTOS
	//
	private String sigla;
	private String nome;
	
	//
	// MÉTODOS
	//
	public Departamento(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
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
	
	/** 
	 * Implementação do método toString que retorna uma String
	 * que descreve o objeto Departamento
	 */
	public String toString() {
		return this.sigla + "-" + this.nome;
	}

	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.sigla, this.nome};
	}
	
	/**
	 * Método utilizado para colocar os departamentos em ordem 
	 */
	public int compareTo(Departamento d) {
		return this.nome.compareTo(d.nome);
	}
}
