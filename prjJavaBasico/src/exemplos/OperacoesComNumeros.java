/*
Fa�a um programa que leia da tela dois valores e escreva: 
Sua soma, Sua diferen�a, Seu produto, A divis�o do primeiro pelo segundo, 
O resto da divis�o do primeiro pelo segundo.
*/
package exemplos;

import java.util.Scanner;

public class OperacoesComNumeros {

	public static void main(String[] args) {
		double num1,num2;	
		Scanner input = new Scanner(System.in);
		System.out.println("Digite dois n�meros:");
	num1 = input.nextDouble();
	num2 = input.nextDouble();
	System.out.println("A soma �: " +(num1 + num2));
	System.out.println("A diferen�a �: " +(num1 - num2));
	System.out.println("O produto �: " +(num1 * num2));
	System.out.println("A divis�o �: " +(num1 / num2));
	System.out.println("O m�dulo �: " +(num1 % num2));
	}

}
