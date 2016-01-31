package controle;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import dados.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		SortedSet ordenada = new TreeSet();
		ordenada.add(new Pessoa("José da Silva",25));
		ordenada.add(new Pessoa("Maria de Souza",51));
		ordenada.add(new Pessoa("Alessandro Cerqueira",43));
		ordenada.add(new Pessoa("Doroteia Azambuja",13));
		
		for (Iterator it = ordenada.iterator(); it.hasNext();) {
			Pessoa p = (Pessoa) it.next();
			System.out.println(p);
			//System.out.println(p.toString());
		}
	}

}
