package exemplos;

import java.util.Scanner;

public class CalculaPedidosFastFood {

	
	public static void main(String[] args) {
		float hamburguer, batata, refrigerante, resultado;
		int h, b, r;
		
		hamburguer=(float)2.50;
		batata=(float)1.50;
		refrigerante=(float)0.60;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de Hamburguer:");
		h= teclado.nextInt();
		
		System.out.println("Digite a quantidade de batata frita:");
		b = teclado.nextInt();
		
		System.out.println("Digite a quantidade de Refrigerante:");
		r = teclado.nextInt();
		
		resultado=(hamburguer*h)+(batata*b)+(refrigerante*r);
		resultado*=1.1;
		
		System.out.println("Valor total é R$ " + resultado);

	}

}
