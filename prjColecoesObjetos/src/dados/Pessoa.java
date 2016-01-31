package dados;

public class Pessoa  implements Comparable{
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int compareTo(Object o){
		if (o instanceof Pessoa){
			Pessoa outro = (Pessoa) o;
			return this.nome.compareTo(outro.nome);
		}
		return -1;
	}
	
	public String toString(){
		return this.nome + "(" + this.idade + ")" /*+ super.toString()*/;
	}
	

}
