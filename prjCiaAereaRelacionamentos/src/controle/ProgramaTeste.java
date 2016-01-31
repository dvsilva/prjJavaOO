package controle;

import dados.Aeroporto;
import dados.Escala;
import dados.Voo;

public class ProgramaTeste {

	public static void main(String[] args) {

		Aeroporto a1 = new Aeroporto ("123","a1", "rua1", "1111-1111");
		Aeroporto a2 = new Aeroporto ("456","a2", "rua2", "2222-2222");
		Aeroporto a3 = new Aeroporto ("789","a3", "rua3", "3333-3333");
		Voo v1 = new Voo("v1", "12:00", "14:00", "19/10/13", null, a1, a2);
		Voo v2 = new Voo("v2", "12:00", "14:00", "29/10/13", null, a2, a1);
		Voo v3 = new Voo("v3", "12:00", "14:00", "29/10/13", null, a3, a2);
		Escala e1 = new Escala("1", "12:00", "10:00", a1, v1);
		Escala e2 = new Escala("2", "12:00", "10:00", a2, v2);
		Escala e3 = new Escala("3", "12:00", "10:00", a3, v3);

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		
		v1.adicionarEscala(e3);
		v2.adicionarEscala(e1);

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);

		/*
		a1.removerVoo(v1);
		a2.removerVoo(v2);

		System.out.println(f1);
		System.out.println(f2);
		System.out.println(m1);
		System.out.println(m2);*/

		
	}

}
