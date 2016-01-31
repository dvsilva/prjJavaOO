package dados;

public class Aluno extends Pessoa{
	
	private String mtr;
	
	public Aluno(String cpf, String nome, String mtr) {
		super(cpf, nome);
		this.mtr = mtr;
	}

	public String getMtr() {
		return mtr;
	}

}
