package exemplos;

import java.util.Scanner;

public class MaiorPreco {
	public static void main(String[] args) {
		
		int i;
		float preco, ma = 0;
		Scanner leia = new Scanner(System.in);
		
		do{
			System.out.print("Digite o preço: R$");
			preco = leia.nextFloat();
			
			if(preco > ma)
				ma = preco;
				
			}while(preco>0);
		System.out.print("Maior preco é: R$" + ma);
		
		
	}

}
