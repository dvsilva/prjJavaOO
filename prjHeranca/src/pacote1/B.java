package pacote1;

public class B extends A {// classe B é especializacao de A chamda de HERANÇA

	public B() {
		// this.x = 40;// NAO POSSO FAZER ISSO...POR O ATRIBUTO X É PRIVATE
		// DEFINADA NA CLASSE A
		this.setX(40);
		this.y = 50;
		this.z = 60;

	}

}
