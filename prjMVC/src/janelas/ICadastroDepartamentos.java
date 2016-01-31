package janelas;

import controle.Tabelavel;

public interface ICadastroDepartamentos {

	/* (non-Javadoc)
	 * @see janelas.ICadastroDepartamentos#limpar()
	 */
	public abstract void limpar();

	/* (non-Javadoc)
	 * @see janelas.ICadastroDepartamentos#incluirLinha(controle.Tabelavel)
	 */
	public abstract void incluirLinha(Tabelavel objeto);

	public abstract void executarIncluir();

	public abstract void executarExcluir();

	public abstract void executarAlterar();

	public abstract void executarTerminar();
	
	public abstract void setVisible(boolean flag);
}