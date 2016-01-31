package dados;

import java.io.Serializable;

public class Assento implements Serializable, Comparable<Assento> {
	//
	//ATRIBUTOS
	//
	private String assentoNum;
	private String assentoFila;
	private Voo voo;
	private Passageiro pass;
	
	//
	//METODOS
	//
	public Assento(String assentoNum, String assentoFila, Voo v, Passageiro p) {
		super();
		this.assentoNum = assentoNum;
		this.assentoFila = assentoFila;
		this.setVoo(v);
		this.setPass(p);
	}
	public String getAssentoNum() {
		return assentoNum;
	}
	public void setAssentoNum(String assentoNum) {
		this.assentoNum = assentoNum;
	}
	public String getAssentoFila() {
		return assentoFila;
	}
	public void setAssentoFila(String assentoFila) {
		this.assentoFila = assentoFila;
	}
	
	
	/**
	 * Retorna um array de Objects com os estados dos atributos 
	 * dos objetos
	 * @return
	 */
	public Object[] getData() {
		return new Object[]{this.assentoNum, this.assentoFila};
	}	

	public boolean setVoo(Voo v){
		if (this.voo ==v)
			return false;
		if (v == null){
			Voo anterior = this.voo;
			this.voo = null;
			anterior.removerAssento (this);
			return true;
		}
		if (this.voo != null){
			this.voo.removerAssento(this);
		}
		this.voo = v;
		v.adicionarAssento(this);
		return true;
	}
	
	public int compareTo(Assento a){
		return this.assentoNum.compareTo(a.assentoNum);
	}
	
	public String toString(){
		//return this.cpf + "-" + this.nome;
		String resultado = this.assentoNum + "-" + this.assentoFila;
		if (this.voo != null)
			resultado += "(" + this.voo.getCodVoo() + ")";
		if (this.pass != null)
			resultado += "(" + this.pass.getCpf() + ")";
		return resultado;
	}

	public boolean setPass(Passageiro p){
		if (this.pass ==p)
			return false;
		if (p == null){
			Passageiro anterior = this.pass;
			this.pass = null;
			anterior.removerAssento (this);
			return true;
		}
		if (this.pass != null){
			this.pass.removerAssento(this);
		}
		this.pass = p;
		p.adicionarAssento(this);
		return true;
	}
}


