package controle;

import javax.swing.JOptionPane;

import janelas.JanelaEmpregado;
import janelas.JanelaExcluirEmpregado;


import janelas.JanelaCadastroEmpregados;
import dados.DAODepartamento;
import dados.DAOEmpregado;
import dados.Departamento;
import dados.Empregado;
import dados.IDAODepartamento;

public class CtrlManterEmpregados implements ICtrlManterEmpregados {
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
	 * Refer�ncia para a janela do cadastro de Empregados
	 */
	private JanelaCadastroEmpregados jCadastro;
	
	/**
	 * Refer�ncia para a janela Empregado que permitir� a 
	 * inclus�o e altera��o do Empregado
	 */
	private JanelaEmpregado jEmpregado;
	
	/**
	 * Refer�ncia para o objeto Empregado sendo manipulado
	 */
	private Empregado empAtual;
	
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
	 * Construtor da classe CtrlManterEmpregados
	 */
	public CtrlManterEmpregados(CtrlPrograma p) {
		// Guardo a refer�ncia para o controlador do programa
		this.ctrlPrg = p;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#iniciar()
	 */
	@Override
	public boolean iniciar() {
		// Se j� est� em execu��o, n�o � necess�rio solicitar 
		// novamente a execu��o do caso de uso
		if(this.emExecucao)
			return false;
		// Crio e abro a janela de cadastro
		this.jCadastro = new JanelaCadastroEmpregados(this);
		// Atualizo a interface
		this.atualizarInterface();
		// Guardo a informa��o que o caso de uso est� em execu��o
		this.emExecucao = true;
		// Indico que o controlador de caso de uso est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#terminar()
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
		this.ctrlPrg.terminarCasoDeUsoManterEmpregados();
		// Guardo a informa��o que o caso de uso est� encerrado
		this.emExecucao = false;
		// Indico que o caso de uso est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}	
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#iniciarIncluir()
	 */
	@Override
	public boolean iniciarIncluir() {
		// Se o controlador n�o est� dispon�vel, n�o inicia a inclus�o
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso est� incluindo
		this.operacao = Operacao.INCLUSAO;
		// Recupero os objetos Departamento do DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		Departamento[] deptos = dao.getListaObjs();
		// Abro a janela de empregado
		this.jEmpregado = new JanelaEmpregado(this, deptos);
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#cancelarIncluir()
	 */
	@Override
	public void cancelarIncluir() {
		if(this.operacao == Operacao.INCLUSAO) {
			// Fecho a janela
			this.jEmpregado.setVisible(false);
			// Indico que o controlador est� dispon�vel
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#incluir(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean incluir(String sigla, String nome, Object depto) {
		// Se o controlador n�o tinha ativado uma inclusao, n�o fa�o nada!
		if(this.operacao != Operacao.INCLUSAO)
			return false;
		// Crio um novo objeto Empregado
		Empregado novo = new Empregado(sigla, nome,(Departamento)depto);
		// Recuperando o DAO
		DAOEmpregado dao = DAOEmpregado.getSingleton();
		// Salvo o objeto Empregado usando o DAO
		dao.salvar(novo);
		// Fecho a janela Empregado
		this.jEmpregado.setVisible(false);
		// Atualizo a interface
		this.atualizarInterface();
		// Indico que o controlador est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#iniciarAlterar(int)
	 */
	@Override
	public boolean iniciarAlterar(int pos) {
		// Se o controlador n�o est� dispon�vel, n�o fa�o nada
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso est� alterando
		this.operacao = Operacao.ALTERACAO;
		// Recuperando o DAO
		DAOEmpregado daoEmpregado = DAOEmpregado.getSingleton();
		// Recupero o  objeto Empregado
		this.empAtual = daoEmpregado.recuperar(pos);
		// Recupero os objetos Departamento do DAO
		IDAODepartamento daoDepartamento = DAODepartamento.getSingleton();
		Departamento[] deptos = daoDepartamento.getListaObjs();
		// Abro a janela Empregado para altera��o
		this.jEmpregado = new JanelaEmpregado(this, deptos);
		this.jEmpregado.atualizarCampos(this.empAtual.getCpf(), 
				                        this.empAtual.getNome(),
				                        this.empAtual.getDepto());
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#cancelarAlterar()
	 */
	@Override
	public void cancelarAlterar() {
		if(this.operacao == Operacao.ALTERACAO) {
			// Fecho a janela
			this.jEmpregado.setVisible(false);
			// N�o guardo uma refer�ncia para o Empregado pois cancelei a altera��o
			this.empAtual = null;
			// Indico que o controlador est� dispon�vel
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#alterar(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean alterar(String cpf, String nome, Object depto) {
		// Se o controlador n�o tinha ativado uma inclusao, n�o fa�o nada!
		if(this.operacao != Operacao.ALTERACAO)
			return false;
		// Atualizo os campos
		this.empAtual.setCpf(cpf);
		this.empAtual.setNome(nome);
		this.empAtual.setDepto((Departamento)depto);
		// Recuperando o DAO
		DAOEmpregado dao = DAOEmpregado.getSingleton();
		// Salvo o objeto Empregado usando o DAO
		dao.atualizar(this.empAtual);
		// Fecho a janela Empregado
		this.jEmpregado.setVisible(false);
		// Atualizo a interface
		this.atualizarInterface();
		// Deixo de guardar a refer�ncia para o Empregado
		this.empAtual = null;
		// Indico que o controlador est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#iniciarExcluir(int)
	 */
	@Override
	public boolean iniciarExcluir(int pos) {
		// Se o controlador n�o est� dispon�vel, n�o fa�o nada
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso est� excluindo
		this.operacao = Operacao.EXCLUSAO;
		// Recuperando o DAO
		DAOEmpregado dao = DAOEmpregado.getSingleton();
		// Recupero o  objeto Empregado
		this.empAtual = dao.recuperar(pos);
		// Abro a janela Empregado para perguntar sobre a exclus�o
		new JanelaExcluirEmpregado(this, this.empAtual);
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#cancelarExcluir()
	 */
	@Override
	public void cancelarExcluir() {
		if(this.operacao == Operacao.EXCLUSAO) {
			// N�o guardo uma refer�ncia para o Empregado pois cancelei a altera��o
			this.empAtual = null;
			// Indico que o controlador est� dispon�vel
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#excluir()
	 */
	@Override
	public boolean excluir() {
		// Se o controlador n�o tinha ativado uma exclus�o, n�o fa�o nada!
		if(this.operacao != Operacao.EXCLUSAO)
			return false;
		// Recuperando o DAO
		DAOEmpregado dao = DAOEmpregado.getSingleton();
		// Salvo o objeto Empregado usando o DAO
		dao.remover(this.empAtual);
		// Atualizo a interface
		this.atualizarInterface();
		// Deixo de guardar a refer�ncia para o Empregado
		this.empAtual = null;
		// Indico que o controlador est� dispon�vel
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterEmpregados#atualizarInterface()
	 */
	@Override
	public void atualizarInterface(){
		// Limpa a tabela da janela
		this.jCadastro.limpar();
		// Recuperando o DAO
		DAOEmpregado dao = DAOEmpregado.getSingleton();
		// Para cada objeto Empregado presente no DAO
		for(int i = 0; i < dao.getNumObjs(); i++) {
			// Recupero um objeto Empregado
			Empregado e = dao.recuperar(i);
			// Coloco uma linha na tabela
			this.jCadastro.incluirLinha(e);
		}
	}
}
