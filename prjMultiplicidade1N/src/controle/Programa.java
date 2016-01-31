package controle;

import dados.Departamento;
import dados.Empregado;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Departamento d1 = new Departamento("RH", "Recursos Humanos");
		Departamento d2 = new Departamento("CB", "Contabilidade");
		Empregado e1 = new Empregado("123-4","Cuca", d1);
		Empregado e2 = new Empregado("567-9","Kiko", d1);
		
		System.out.println(d1);
		System.out.println(d2);
		
	}

}
