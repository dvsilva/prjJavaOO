package pacote1;

public class A {
	private int x;// Visibilidade private; s� � visivel no contesto da classe
					// definida;
	protected int y;// Visibilidade protegida � manipulada NA CLASSE. E NAS
					// CLASSES DO MESMO PACOTE e nas suas especializa��es
	int z;// visibilidade package � vista pelas classes do mesmo pacote;

	public A() {// visibilidade public ...todo mundo pode utilizar esse
				// atributo...� publica

		this.x = 10;
		this.y = 20;
		this.z = 30;
	}

	public void alteraOutroA(A outroA) {

		outroA.x = this.x;
		outroA.y = this.y;
		outroA.z = this.z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {

		this.z = z;
	}

	public int getZ() {
		return z;

	}

}
