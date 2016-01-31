package testes;

import dados.Fabricante;
import dados.Modelo;

public class TesteFabricanteModelo {

	public static void main(String[] args) {
		Fabricante f1 = new Fabricante("Fab1","0000-0000");
		Fabricante f2 = new Fabricante("Fab2","0000-0000");
		Modelo m1 = new Modelo("m1", "10", "1", "2",f1);
		Modelo m2 = new Modelo("m2", "10", "1", "2", f2);
		Modelo m3 = new Modelo("m3", "10", "1", "2",null);
		Modelo m4 = new Modelo("m4", "10", "1", "2", null);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		f1.adicionarModelo(m3);
		f2.adicionarModelo(m4);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		f1.removerModelo(m3);
		f2.removerModelo(m4);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		m1.setFabricante(f2);
		m2.setFabricante(f1);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);

	}

}
