package testes;

import dados.Aeroporto;
import dados.Escala;
import dados.Voo;

public class TesteVooEscalaAeroporto {

	public static void main(String[] args) {

		Voo v1 = new Voo("v1","12:00", "14:00", "19/10/13",null, null, null);
		Voo v2 = new Voo("v2","12:00", "14:00", "29/10/13", null, null, null);
		Aeroporto a1 = new Aeroporto("1", "Galeao", "Linha Vermelha", "0000-0000");
		Aeroporto a2 = new Aeroporto("2", "Santos D.", "S/N", "1111-1111");
		Escala e1 = new Escala("1", "14:00", "13:00", a1, v1);
		Escala e2 = new Escala("2", "14:00", "13:00", null, null);
		Escala e3 = new Escala("3", "14:00", "13:00", a2, v2);
		Escala e4 = new Escala("4", "14:00", "13:00", null, null);
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);

		v1.adicionarEscala(e2);
		v2.adicionarEscala(e4);
		a1.adicionarEscala(e2);
		a2.adicionarEscala(e4);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);

		v1.removerEscala(e2);
		v2.removerEscala(e4);
		a1.removerEscala(e2);
		a2.removerEscala(e4);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);


		e1.setAeroporto(a2);
		e3.setAeroporto(a1);
		e1.setVoo(v2);
		e3.setVoo(v1);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);


	}

}
