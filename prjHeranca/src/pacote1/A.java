package pacote1;

public class A {
	private int x;// Visibilidade private; só é visivel no contesto da classe
					// definida;
	protected int y;// Visibilidade protegida é manipulada NA CLASSE. E NAS
					// CLASSES DO MESMO PACOTE e nas suas especializações
	int z;// visibilidade package é vista pelas classes do mesmo pacote;

	public A() {// visibilidade public ...todo mundo pode utilizar esse
				// atributo...é publica

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
