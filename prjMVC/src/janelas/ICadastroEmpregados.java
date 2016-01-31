package janelas;

import controle.Tabelavel;

public interface ICadastroEmpregados {

	/**
	 * Remove todas as linhas da tabela
	 */
	public abstract void limpar();

	/**
	 * Inclui uma linha na tabela
	 * @param linha
	 */
	public abstract void incluirLinha(Tabelavel objeto);

}