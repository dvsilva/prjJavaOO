package dados;

public class Empregado implements Comparable<Empregado>{

	private String cpf;
	private String nome;

	// Relacionamento Unário com Departamento
	private Departamento depto;

	public Empregado(String cpf, String nome, Departamento d) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.setDepto(d);
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

	public boolean setDepto(Departamento d) {
		if (this.depto == d)
			return false;
		if (d == null) {
			Departamento anterior = this.depto;
			this.depto = null;
			anterior.removerEmpregado(this);
			return true;
		}
		if(this.depto != null){
			this.depto.removerEmpregado(this);
		}
		this.depto = d;
		d.adicionarEmpregado(this);
		return true;
	}

	public int compareTo(Empregado e){
		return this.nome.compareTo(e.nome);
	}
	
	public String toString(){
		//return this.cpf + "-" + this.nome;
		String resultado = "(" + this.depto.getNome() + ")";
		return resultado;
	}
}
