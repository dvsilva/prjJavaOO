package testes;

import dados.Aeronave;
import dados.Voo;

public class TesteAeronaveVoo {
	
	public static void main(String[] args) {
		
		Aeronave a1 = new Aeronave("Aeronave1",	null);
		Aeronave a2 = new Aeronave("Aeronave2", null);
		Voo v1 = new Voo("v1","12:00", "14:00", "19/10/13",a1, null, null);
		Voo v2 = new Voo("v2","12:00", "14:00", "29/10/13", a2, null, null);
		Voo v3 = new Voo("v3","12:00", "14:00", "29/10/13", null, null, null);
		Voo v4 = new Voo("v4","12:00", "14:00", "29/10/13", null, null, null);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);

		a1.adicionarVoo(v3);
		a2.adicionarVoo(v4);

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);

		a1.removerVoo(v3);
		a2.removerVoo(v4);

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);

		v1.setAeronave(a2);
		v2.setAeronave(a1);

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);


	}

}
