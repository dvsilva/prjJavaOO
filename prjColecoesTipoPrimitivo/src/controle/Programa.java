package controle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Programa {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		//ArrayList c = new ArrayList();
		String s1 = "primeiro";
		String s2 = "segundo";
		String s3 = "terceiro";
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s2);
		
		for (Iterator iterator = c.iterator();iterator.hasNext();) {
			//Object object = (Object) iterator.next();
			String s = (String) iterator.next();
			System.out.println(s);
		}
	}

}
