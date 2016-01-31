/*
Faça um programa que leia da tela dois valores e escreva: 
Sua soma, Sua diferença, Seu produto, A divisão do primeiro pelo segundo, 
O resto da divisão do primeiro pelo segundo.
*/
package exemplos;

import java.util.Scanner;

public class OperacoesComNumeros {

	public static void main(String[] args) {
		double num1,num2;	
		Scanner input = new Scanner(System.in);
		System.out.println("Digite dois números:");
	num1 = input.nextDouble();
	num2 = input.nextDouble();
	System.out.println("A soma é: " +(num1 + num2));
	System.out.println("A diferença é: " +(num1 - num2));
	System.out.println("O produto é: " +(num1 * num2));
	System.out.println("A divisão é: " +(num1 / num2));
	System.out.println("O módulo é: " +(num1 % num2));
	}

}
