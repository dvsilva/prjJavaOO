package pacote1;

public class C {

	public A criarObjetoA() {
		A umObjA = new A();
		umObjA.setX(100); // mandando msg pelo setX
		umObjA.y = 200;// quebrando a regra do encapsulamento
		umObjA.z = 300;
		return umObjA;

	}
}
