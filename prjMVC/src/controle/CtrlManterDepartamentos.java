package controle;

import janelas.ICadastroDepartamentos;
import janelas.IDepartamento;
import janelas.JanelaCadastroDepartamentos;
import janelas.JanelaDepartamento;
import janelas.JanelaExcluirDepartamento;
import dados.DAODepartamento;
import dados.Departamento;
import dados.IDAODepartamento;

public class CtrlManterDepartamentos implements ICtrlManterDepartamentos {
	//
	// ATRIBUTOS
	//
	private enum Operacao {
		INCLUSAO, EXCLUSAO, ALTERACAO, DISPONIVEL;
	}
	
	/**
	 * Refer�ncia para o controlador do programa.
	 */
	private CtrlPrograma       ctrlPrg;
	
	/**
	 * Refer�ncia para a janela do cadastro de Departamentos
	 */
	private ICadastroDepartamentos jCadastro;
	
	/**
	 * Refer�ncia para a janela Departamento que permitir� a 
	 * inclus�o e altera��o do Departamento
	 */
	private IDepartamento jDepartamento;
	
	/**
	 * Refer�ncia para o objeto Departamento sendo manipulado
	 */
	private Departamento deptoAtual;
	
	/**
	 * Atributo indicando se o caso de uso est� ou n�o em execu��o
	 */
	private boolean emExecucao;
	
	/**
	 * Atributo que indica qual opera��o est� em curso
	 */
	private Operacao operacao;
	
	//
	// M�TODOS
	//
	
	/**
	 * Construtor da classe CtrlManterDepartamentos
	 */
	public CtrlManterDepartamentos(CtrlPrograma p) {
		// Guardo a refer�ncia para o controlador do programa
		this.ctrlPrg = p;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciar()
	 */
	@Override
	public boolean iniciar() {
		// Se j� est� em execu��o, n�o � necess�rio solicitar 
		// novamente a execu��o do caso de uso
		if(this.emExecucao)
			return false;
		// Crio e abro a janela de cadastro
		this.jCadastro = new JanelaCadastroDepartamentos(this);
		// Atualizo a interface
		this.atualizarInterface();
		// Guardo a informa��o que o caso de uso est� em execu��o
		this.emExecucao = true;
		// Indico que o controlador de caso de uso est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#terminar()
	 */
	@Override
	public boolean terminar() {
		// Se n�o est� em execu��o, n�o � necess�rio solicitar 
		// novamente o t�rmino do caso de uso
		if(!this.emExecucao)
			return false;
		// Fecho a janela
		this.jCadastro.setVisible(false);
		// Notifico ao controlador do programa o t�rmino do caso de uso
		this.ctrlPrg.terminarCasoDeUsoManterDepartamentos();
		// Guardo a informa��o que o caso de uso est� encerrado
		this.emExecucao = false;
		// Indico que o caso de uso est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}	
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciarIncluir()
	 */
	@Override
	public boolean iniciarIncluir() {
		// Se o controlador n�o est� dispon�vel, n�o inicia a inclus�o
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso est� incluindo
		this.operacao = Operacao.INCLUSAO;
		// Abro a janela de departamento
		this.jDepartamento = new JanelaDepartamento(this);
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#cancelarIncluir()
	 */
	@Override
	public void cancelarIncluir() {
		if(this.operacao == Operacao.INCLUSAO) {
			// Fecho a janela
			this.jDepartamento.setVisible(false);
			// Indico que o controlador est� dispon�vel
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#incluir(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean incluir(String sigla, String nome) {
		// Se o controlador n�o tinha ativado uma inclusao, n�o fa�o nada!
		if(this.operacao != Operacao.INCLUSAO)
			return false;
		// Crio um novo objeto Departamento
		Departamento novo = new Departamento(sigla, nome);
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Salvo o objeto Departamento usando o DAO
		dao.salvar(novo);
		// Fecho a janela Departamento
		this.jDepartamento.setVisible(false);
		// Atualizo a interface
		this.atualizarInterface();
		// Indico que o controlador est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciarAlterar(int)
	 */
	@Override
	public boolean iniciarAlterar(int pos) {
		// Se o controlador n�o est� dispon�vel, n�o fa�o nada
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso est� alterando
		this.operacao = Operacao.ALTERACAO;
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Recupero o  objeto Departamento
		this.deptoAtual = dao.recuperar(pos);
		// Abro a janela Departamento para altera��o
		this.jDepartamento = new JanelaDepartamento(this);
		this.jDepartamento.atualizarCampos(this.deptoAtual.getSigla(), 
				                        this.deptoAtual.getNome());
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#cancelarAlterar()
	 */
	@Override
	public void cancelarAlterar() {
		if(this.operacao == Operacao.ALTERACAO) {
			// Fecho a janela
			this.jDepartamento.setVisible(false);
			// N�o guardo uma refer�ncia para o Departamento pois cancelei a altera��o
			this.deptoAtual = null;
			// Indico que o controlador est� dispon�vel
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#alterar(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean alterar(String sigla, String nome) {
		// Se o controlador n�o tinha ativado uma inclusao, n�o fa�o nada!
		if(this.operacao != Operacao.ALTERACAO)
			return false;
		// Atualizo os campos
		this.deptoAtual.setSigla(sigla);
		this.deptoAtual.setNome(nome);
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Salvo o objeto Departamento usando o DAO
		dao.atualizar(this.deptoAtual);
		// Fecho a janela Departamento
		this.jDepartamento.setVisible(false);
		// Atualizo a interface
		this.atualizarInterface();
		// Deixo de guardar a refer�ncia para o Departamento
		this.deptoAtual = null;
		// Indico que o controlador est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciarExcluir(int)
	 */
	@Override
	public boolean iniciarExcluir(int pos) {
		// Se o controlador n�o est� dispon�vel, n�o fa�o nada
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso est� excluindo
		this.operacao = Operacao.EXCLUSAO;
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Recupero o  objeto Departamento
		this.deptoAtual = dao.recuperar(pos);
		// Abro a janela Departamento para perguntar sobre a exclus�o
		new JanelaExcluirDepartamento(this, this.deptoAtual);
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#cancelarExcluir()
	 */
	@Override
	public void cancelarExcluir() {
		if(this.operacao == Operacao.EXCLUSAO) {
			// N�o guardo uma refer�ncia para o Departamento pois cancelei a altera��o
			this.deptoAtual = null;
			// Indico que o controlador est� dispon�vel
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#excluir()
	 */
	@Override
	public boolean excluir() {
		// Se o controlador n�o tinha ativado uma exclus�o, n�o fa�o nada!
		if(this.operacao != Operacao.EXCLUSAO)
			return false;
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Salvo o objeto Departamento usando o DAO
		dao.remover(this.deptoAtual);
		// Atualizo a interface
		this.atualizarInterface();
		// Deixo de guardar a refer�ncia para o Departamento
		this.deptoAtual = null;
		// Indico que o controlador est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#atualizarInterface()
	 */
	@Override
	public void atualizarInterface(){
		// Limpa a tabela da janela
		this.jCadastro.limpar();
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Para cada objeto Departamento presente no DAO
		for(int i = 0; i < dao.getNumObjs(); i++) {
			// Recupero um objeto Departamento
			Departamento depto = dao.recuperar(i);
			// Coloco uma linha na tabela
			this.jCadastro.incluirLinha(depto);
		}
	}
}
