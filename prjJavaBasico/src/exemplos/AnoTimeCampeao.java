package exemplos;

import java.util.Scanner;

public class AnoTimeCampeao {


	public static void main(String[] args) {
		
		int ano;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite ano:");
		ano = teclado.nextInt();
		
		switch(ano){
		case 2009: System.out.print("Flamengo Campe�o");break;
		case 2010: System.out.print("Fluminense Campe�o");break;
		case 2011: System.out.print("Vasco Vice-campe�o");break;
		default: System.out.print("Botafogo um time bacana"); break;
		}

	}

}
