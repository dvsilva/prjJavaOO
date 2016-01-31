package exemplos;

public class ExemploTipoDadosCompactados {
	public static void main(String[] args) {
		String nome = "Anderson Mendes"; //é uma classe não dado, cadeia de caracteres
		int idade   = 22; //numeros inteiros
		float peso  = (float) 82.5, altura = (float) 1.77; //numeros com casas decimais
		char sexo   = 'M'; //apenas um caractere
		
		System.out.println("Nome: " + nome);
		System.out.println("Peso: " + peso + "kg");
		System.out.println("Altura: " + altura + "cm");
		System.out.println("Idade: " + idade + " anos");
		System.out.print("Sexo: " + sexo);
	}

}
