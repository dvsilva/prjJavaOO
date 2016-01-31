package janelas;

import javax.swing.JOptionPane;

import controle.CtrlManterEmpregados;
import controle.ICtrlManterDepartamentos;

/**
 * Implementação da janela de confirmação de exclusão do departamento
 * @author Alessandro Cerqueira
 *
 */
public class JanelaExcluirDepartamento {
	/**
	 * Referência para o controlador do caso de uso
	 */
	private ICtrlManterDepartamentos ctrl;
	
	/**
	 * Opção escolhida pelo usuário
	 */
	private int opcao;
	
	
	/**
	 * Construtor que irá colocar uma janela modal perguntando
	 * se o usuário deseja ou não excluir o departamento
	 * @param nome
	 */
	public JanelaExcluirDepartamento(ICtrlManterDepartamentos ct, Object selecionado){
		// Guardo a referência para o controlador de caso de uso
		this.ctrl = ct;
		// Pergunto ao usuário o que ele deseja fazer
		this.opcao = JOptionPane.showConfirmDialog(null, "Deseja remover o Departamento " + selecionado);
		// Verifica o que o usuário indicou para ser feito
		if(this.opcao == JOptionPane.YES_OPTION)
			this.ctrl.excluir();
		else
			this.ctrl.cancelarExcluir();
	}
	
	/**
	 * Retorna a opção indicada pelo usuário
	 * @return
	 */
	public int getOpcao(){
		return this.opcao;
	}
}
