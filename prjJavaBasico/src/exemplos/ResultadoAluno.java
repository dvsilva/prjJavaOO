package exemplos;

import java.util.Scanner;

public class ResultadoAluno {

	
	public static void main(String[] args) {
		float nota1, nota2, media;
		
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite 1ª nota");
		nota1=teclado.nextFloat();
		
		System.out.println("Digite 2ª nota");
		nota2=teclado.nextFloat();
		
		media=(float)(nota1+nota2)/2;
		
		if(media<4.0){
			System.out.println("Reprovado");
		}
		
		else if(media<7.0){
			System.out.println("Exame");
		}
			else{
				System.out.println("Aprovado");
			}
	}

}
