package testes;

import dados.Assento;
import dados.Passageiro;
import dados.Voo;

public class TesteVooAssentoPassageiro {


	public static void main(String[] args) {
		
		Voo v1 = new Voo("v1","12:00", "14:00", "19/10/13",null, null, null);
		Voo v2 = new Voo("v2","12:00", "14:00", "29/10/13", null, null, null);
		Passageiro p1 = new Passageiro("123","Maria", "Rua 1", "0000-0000");
		Passageiro p2 = new Passageiro("456","João", "Rua 2", "1111-1111");
		Assento a1 = new Assento("1","A", v1, p1);
		Assento a2 = new Assento("2","B", null, null);
		Assento a3 = new Assento("3","C", v2, p2);
		Assento a4 = new Assento("4","D", null, null);
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);

		v1.adicionarAssento(a2);
		v2.adicionarAssento(a4);
		p1.adicionarAssento(a2);
		p2.adicionarAssento(a4);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);

		v1.removerAssento(a2);
		v2.removerAssento(a4);
		p1.removerAssento(a2);
		p2.removerAssento(a4);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);


		a1.setPass(p2);
		a3.setPass(p1);
		a1.setVoo(v2);
		a3.setVoo(v1);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);


	}

}
