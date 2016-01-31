package controle;

public class RaizQuadradaException extends Exception {
	public RaizQuadradaException (double valor){
		super ("O valor passado é inválido: " + valor);
		
	}

}
