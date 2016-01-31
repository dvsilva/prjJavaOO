package janelas;

public interface IDepartamento {

	/**
	 * Determina os valores para os campos da janela
	 * @param sigla
	 * @param nome
	 */
	public abstract void atualizarCampos(String sigla, String nome);

	public void setVisible(boolean flag);
}