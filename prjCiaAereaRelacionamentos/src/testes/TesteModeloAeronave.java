package testes;

import dados.Aeronave;
import dados.Modelo;

public class TesteModeloAeronave {

	public static void main(String[] args) {
		
		Modelo m1 = new Modelo("m1", "10", "1", "2", null);
		Modelo m2 = new Modelo("m2", "10", "1", "2", null);
		Aeronave a1 = new Aeronave("Aeronave1",m1);
		Aeronave a2 = new Aeronave("Aeronave2", m2);
		Aeronave a3 = new Aeronave("Aeronave3",null);
		Aeronave a4 = new Aeronave("Aeronave4", null);

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);

		m1.adicionarAeronave(a3);
		m2.adicionarAeronave(a4);

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);

		m1.removerAeronave(a3);
		m2.removerAeronave(a4);

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);


		a1.setModelo(m2);
		a2.setModelo(m1);

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);


	}

}
