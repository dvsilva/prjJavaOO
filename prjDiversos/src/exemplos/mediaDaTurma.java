package exemplos;

import java.util.Scanner;

public class mediaDaTurma {
	
	public static void main(String[] args) {
		
		int i;
		float nota, soma = 0, md;
		
		Scanner leia = new Scanner(System.in);
		
		for (i=1; i<=10; i++){
			System.out.print("Digite a nota do aluno " +i + ": ");
			nota = leia.nextFloat();
			
			while((nota <0 ) || (nota > 10)) {
				System.out.println("Nota Invalida");
				System.out.print("Digite novamente a nota: ");
				nota = leia.nextFloat();
				
			}
			soma+=nota;
			
		}
			
		md = soma / --i;
		System.out.println("A média da turma é: " + md);
		
		
	}

}
