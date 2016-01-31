package controle;

public interface ICtrlManterDepartamentos {

	/**
	 * M�todo que dispara a execu��o do caso de uso
	 * Manter Departamentos.
	 */
	public abstract boolean iniciar();

	/**
	 * M�todo que encerra a execu��o do caso de uso
	 * Manter Departamentos.
	 */
	public abstract boolean terminar();

	/**
	 * M�todo que inicia o processo de inclus�o de um Departamento
	 */
	public abstract boolean iniciarIncluir();

	/**
	 * M�todo que cancela o processo de inclus�o de um Departamento
	 */
	public abstract void cancelarIncluir();

	/**
	 * M�todo que inclui um Departamento
	 */
	public abstract boolean incluir(String sigla, String nome);

	/**
	 * M�todo que inicia o processo de altera��o de um Departamento
	 */
	public abstract boolean iniciarAlterar(int pos);

	/**
	 * M�todo que cancela o processo de altera��o de um Departamento
	 */
	public abstract void cancelarAlterar();

	/**
	 * M�todo que alterar um Departamento
	 */
	public abstract boolean alterar(String sigla, String nome);

	/**
	 * M�todo que inicia o processo de exclus�o de um Departamento
	 */
	public abstract boolean iniciarExcluir(int pos);

	/**
	 * M�todo que cancela o processo de exclus�o de um Departamento
	 */
	public abstract void cancelarExcluir();

	/**
	 * M�todo que exclui um Departamento
	 */
	public abstract boolean excluir();

	/**
	 * Atualiza a Janela Cadastro
	 */
	public abstract void atualizarInterface();

}