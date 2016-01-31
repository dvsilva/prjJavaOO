package janelas;

public interface IEmpregado {

	/**
	 * Determina os valores para os campos da janela
	 * @param cpf
	 * @param nome
	 */
	public abstract void atualizarCampos(String cpf, String nome, Object depto);

}