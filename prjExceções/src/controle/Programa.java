package controle;

public class Programa {

	public static void main(String[] args) {
		try{
		Exemplo.raizQuadrada(-2.0);
		}
		catch(RaizQuadradaException rqe){
			System.out.println("Seu burro! N�o pode! Deu exce��o");
			System.out.println(rqe.getMessage());
			rqe.printStackTrace();
		}
	}

}
