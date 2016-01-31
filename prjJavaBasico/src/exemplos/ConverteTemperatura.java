package exemplos;

import java.util.Scanner;

public class ConverteTemperatura {


	public static void main(String[] args) {
		float c, f;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o valor em Farenheit: ");
		f = teclado.nextFloat();
		
		c=(f-32)/9;
		c/=5;
		
		System.out.print("O valor em Celsius é "+ c);
	}

}
