package exemplos;

import java.util.Scanner;

/*
 * + adição
 * - subtração
 * * multiplicação
 * / divisão
 * % mod
 */

public class CalculaMedia {

	public static void main(String[] args) {
		float nota1, nota2, media;
		
		Scanner recebeValor = new Scanner(System.in);
		
		System.out.print("Digite a nota 01: ");
		nota1 = recebeValor.nextFloat();
		
		System.out.print("Digite a nota 02: ");
		nota2 = recebeValor.nextFloat();
		
		media = (nota1+nota2)/2;
		
		System.out.print("Média: " + media);
	}

}
