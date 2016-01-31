/*Ler na tela de 1 a 7
e imprimir o dia da semana*/

package controle;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o dia:");
		n = input.nextInt();
		
		while (n < 0 || n > 7){
			System.out.println("Dia Inválido!");
			System.out.println("Digite o dia:");
			n = input.nextInt();}
			
		switch (n){
		case 1: System.out.println("Segunda-feira");break;
		case 2: System.out.println("Terça-feira");break;
		case 3: System.out.println("Quarta-feira");break;
		case 4: System.out.println("Quinta-feira");break;
		case 5: System.out.println("Sexta-feira");break;
		case 6: System.out.println("Sábado");break;
		case 7: System.out.println("Domingo");break;
		default: System.out.println("Número Inválido");break;

		
		}
			
		//aceita int, char, string, byte
	}
	

}
