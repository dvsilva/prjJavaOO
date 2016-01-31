package exemplos;

import java.util.Scanner;

// Scanner = classe para entrada de dados. (leitura)

/* 
 * Instância de uma classe:
 * Sintaxe: Classe nome_objeto = new Classe(parâmetro);  
 */

public class ExemploSysOut2 {
	public static void main(String[] args) {
		String nome;
		int idade;
		float peso, altura;
		
		Scanner leitura = new Scanner(System.in);
		
		System.out.print("Digite o nome: ");
		nome = leitura.nextLine();
		
		System.out.print("Digite a idade: ");
		idade = leitura.nextInt();
		
		System.out.print("Digite o peso: ");
		peso = leitura.nextFloat();
		
		System.out.print("Digite a altura: ");
		altura = leitura.nextFloat();
	}

}
