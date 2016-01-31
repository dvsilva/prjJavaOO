package controle;

public interface ICtrlManterEmpregados {

	/**
	 * Método que dispara a execução do caso de uso
	 * Manter Empregados.
	 */
	public abstract boolean iniciar();

	/**
	 * Método que encerra a execução do caso de uso
	 * Manter Empregados.
	 */
	public abstract boolean terminar();

	/**
	 * Método que inicia o processo de inclusão de um Empregado
	 */
	public abstract boolean iniciarIncluir();

	/**
	 * Método que cancela o processo de inclusão de um Empregado
	 */
	public abstract void cancelarIncluir();

	/**
	 * Método que inclui um Empregado
	 */
	public abstract boolean incluir(String sigla, String nome, Object depto);

	/**
	 * Método que inicia o processo de alteração de um Empregado
	 */
	public abstract boolean iniciarAlterar(int pos);

	/**
	 * Método que cancela o processo de alteração de um Empregado
	 */
	public abstract void cancelarAlterar();

	/**
	 * Método que alterar um Empregado
	 */
	public abstract boolean alterar(String cpf, String nome, Object depto);

	/**
	 * Método que inicia o processo de exclusão de um Empregado
	 */
	public abstract boolean iniciarExcluir(int pos);

	/**
	 * Método que cancela o processo de exclusão de um Empregado
	 */
	public abstract void cancelarExcluir();

	/**
	 * Método que exclui um Empregado
	 */
	public abstract boolean excluir();

	/**
	 * Atualiza a Janela Cadastro
	 */
	public abstract void atualizarInterface();

}