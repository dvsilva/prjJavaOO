package exemplos;

import java.util.Scanner;

public class somaDezNumeros {
	
	public static void main(String[] args) {
		
		
		int i, num, soma = 0;
		
		Scanner leia = new Scanner(System.in);
		
		for(i = 1; i<=10; i++){
		
			System.out.print("Digite um numero: ");
			num = leia.nextInt(); 
			soma += num;
		}		
		System.out.print("A soma dos valore é: " + soma);
	
	}

}
