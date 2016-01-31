package controle;

public class Exemplo {
	public final static double ERRO_MAXIMO = 0.000000001;
	
	public static double raizQuadrada (double valor)
	 	throws RaizQuadradaException
	 	{
		double resultado;
		if (valor < 0.0)
			throw new RaizQuadradaException (valor);
			double maior = valor;
			double menor = 0;
			while (true){
				resultado = (maior + menor)/2;
				double erro = (resultado * resultado) - valor;
				if (Math.abs(erro) < ERRO_MAXIMO)
					return  resultado;
				if  (erro > 0)
					maior = resultado;
				else
					menor = resultado;
			}
	 	}
}
