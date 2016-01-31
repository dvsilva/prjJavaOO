package exemplos;

public class ExemploTipoDados {
	public static void main(String[] args) {
		String nome; //é uma classe não dado, cadeia de caracteres
		int idade; //numeros inteiros
		float peso, altura; //numeros com casas decimais
		char sexo; //apenas um caractere
		
		nome   = "Anderson Mendes";
		idade  = 22;
		peso   = (float) 82.2; //forçando para ser float
		altura = (float) 1.77;
		sexo   = 'M';
		
		System.out.println("Nome: " + nome);
		System.out.println("Peso: " + peso + "kg");
		System.out.println("Altura: " + altura + "cm");
		System.out.println("Idade: " + idade + " anos");
		System.out.print("Sexo: " + sexo);
	}

}
