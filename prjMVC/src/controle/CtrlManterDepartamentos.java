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
	 * Referência para o controlador do programa.
	 */
	private CtrlPrograma       ctrlPrg;
	
	/**
	 * Referência para a janela do cadastro de Departamentos
	 */
	private ICadastroDepartamentos jCadastro;
	
	/**
	 * Referência para a janela Departamento que permitirá a 
	 * inclusão e alteração do Departamento
	 */
	private IDepartamento jDepartamento;
	
	/**
	 * Referência para o objeto Departamento sendo manipulado
	 */
	private Departamento deptoAtual;
	
	/**
	 * Atributo indicando se o caso de uso está ou não em execução
	 */
	private boolean emExecucao;
	
	/**
	 * Atributo que indica qual operação está em curso
	 */
	private Operacao operacao;
	
	//
	// MÉTODOS
	//
	
	/**
	 * Construtor da classe CtrlManterDepartamentos
	 */
	public CtrlManterDepartamentos(CtrlPrograma p) {
		// Guardo a referência para o controlador do programa
		this.ctrlPrg = p;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciar()
	 */
	@Override
	public boolean iniciar() {
		// Se já está em execução, não é necessário solicitar 
		// novamente a execução do caso de uso
		if(this.emExecucao)
			return false;
		// Crio e abro a janela de cadastro
		this.jCadastro = new JanelaCadastroDepartamentos(this);
		// Atualizo a interface
		this.atualizarInterface();
		// Guardo a informação que o caso de uso está em execução
		this.emExecucao = true;
		// Indico que o controlador de caso de uso está disponível
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#terminar()
	 */
	@Override
	public boolean terminar() {
		// Se não está em execução, não é necessário solicitar 
		// novamente o término do caso de uso
		if(!this.emExecucao)
			return false;
		// Fecho a janela
		this.jCadastro.setVisible(false);
		// Notifico ao controlador do programa o término do caso de uso
		this.ctrlPrg.terminarCasoDeUsoManterDepartamentos();
		// Guardo a informação que o caso de uso está encerrado
		this.emExecucao = false;
		// Indico que o caso de uso está disponível
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}	
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciarIncluir()
	 */
	@Override
	public boolean iniciarIncluir() {
		// Se o controlador não está disponível, não inicia a inclusão
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso está incluindo
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
			// Indico que o controlador está disponível
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#incluir(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean incluir(String sigla, String nome) {
		// Se o controlador não tinha ativado uma inclusao, não faço nada!
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
		// Indico que o controlador está disponível
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciarAlterar(int)
	 */
	@Override
	public boolean iniciarAlterar(int pos) {
		// Se o controlador não está disponível, não faço nada
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso está alterando
		this.operacao = Operacao.ALTERACAO;
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Recupero o  objeto Departamento
		this.deptoAtual = dao.recuperar(pos);
		// Abro a janela Departamento para alteração
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
			// Não guardo uma referência para o Departamento pois cancelei a alteração
			this.deptoAtual = null;
			// Indico que o controlador está disponível
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#alterar(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean alterar(String sigla, String nome) {
		// Se o controlador não tinha ativado uma inclusao, não faço nada!
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
		// Deixo de guardar a referência para o Departamento
		this.deptoAtual = null;
		// Indico que o controlador está disponível
		this.operacao = Operacao.DISPONIVEL;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#iniciarExcluir(int)
	 */
	@Override
	public boolean iniciarExcluir(int pos) {
		// Se o controlador não está disponível, não faço nada
		if(this.operacao != Operacao.DISPONIVEL)
			return false;
		// Indico que o controlador de caso de uso está excluindo
		this.operacao = Operacao.EXCLUSAO;
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Recupero o  objeto Departamento
		this.deptoAtual = dao.recuperar(pos);
		// Abro a janela Departamento para perguntar sobre a exclusão
		new JanelaExcluirDepartamento(this, this.deptoAtual);
		return true;
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#cancelarExcluir()
	 */
	@Override
	public void cancelarExcluir() {
		if(this.operacao == Operacao.EXCLUSAO) {
			// Não guardo uma referência para o Departamento pois cancelei a alteração
			this.deptoAtual = null;
			// Indico que o controlador está disponível
			this.operacao = Operacao.DISPONIVEL;
		}
	}	

	/* (non-Javadoc)
	 * @see controle.ICtrlManterDepartamentos#excluir()
	 */
	@Override
	public boolean excluir() {
		// Se o controlador não tinha ativado uma exclusão, não faço nada!
		if(this.operacao != Operacao.EXCLUSAO)
			return false;
		// Recuperando o DAO
		IDAODepartamento dao = DAODepartamento.getSingleton();
		// Salvo o objeto Departamento usando o DAO
		dao.remover(this.deptoAtual);
		// Atualizo a interface
		this.atualizarInterface();
		// Deixo de guardar a referência para o Departamento
		this.deptoAtual = null;
		// Indico que o controlador está disponível
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
