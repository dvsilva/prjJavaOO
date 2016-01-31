package controle;

public interface ICtrlManterEmpregados {

	/**
	 * M�todo que dispara a execu��o do caso de uso
	 * Manter Empregados.
	 */
	public abstract boolean iniciar();

	/**
	 * M�todo que encerra a execu��o do caso de uso
	 * Manter Empregados.
	 */
	public abstract boolean terminar();

	/**
	 * M�todo que inicia o processo de inclus�o de um Empregado
	 */
	public abstract boolean iniciarIncluir();

	/**
	 * M�todo que cancela o processo de inclus�o de um Empregado
	 */
	public abstract void cancelarIncluir();

	/**
	 * M�todo que inclui um Empregado
	 */
	public abstract boolean incluir(String sigla, String nome, Object depto);

	/**
	 * M�todo que inicia o processo de altera��o de um Empregado
	 */
	public abstract boolean iniciarAlterar(int pos);

	/**
	 * M�todo que cancela o processo de altera��o de um Empregado
	 */
	public abstract void cancelarAlterar();

	/**
	 * M�todo que alterar um Empregado
	 */
	public abstract boolean alterar(String cpf, String nome, Object depto);

	/**
	 * M�todo que inicia o processo de exclus�o de um Empregado
	 */
	public abstract boolean iniciarExcluir(int pos);

	/**
	 * M�todo que cancela o processo de exclus�o de um Empregado
	 */
	public abstract void cancelarExcluir();

	/**
	 * M�todo que exclui um Empregado
	 */
	public abstract boolean excluir();

	/**
	 * Atualiza a Janela Cadastro
	 */
	public abstract void atualizarInterface();

}