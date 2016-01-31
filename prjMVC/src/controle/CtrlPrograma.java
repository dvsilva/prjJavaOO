package controle;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.ObjectInputStream;

import dados.DAODepartamento;
import dados.DAOEmpregado;
import dados.IDAODepartamento;

import janelas.JanelaPrincipal;

/**
 * Este é o controlador que gerencia a execução do meu programa.
 * @author Alessandro Cerqueira
 */
public class CtrlPrograma {
	//
	// ATRIBUTOS
	// ---------
	// O controlador do programa deve ter um atributo para
	// cada controlador de caso de uso do programa.
	//
	// Também o controlador do programa deve ter um atributo 
	// para referenciar a janela principal do programa.
	//

	/**
	 * Referência para o controlador do caso de uso 
	 * Manter Departamentos
	 */
	private ICtrlManterDepartamentos ctrlDepartamentos;
	/**
	 * Referência para o controlador do caso de uso 
	 * Manter Empregados
	 */
	private ICtrlManterEmpregados    ctrlEmpregados;
	/**
	 * Referência para a janela principal do programa
	 */
	private JanelaPrincipal         jPrincipal;	
	//
	// MÉTODOS
	//

	/**
	 * Construtor do CtrlPrograma
	 */
	public CtrlPrograma(){
		// Instanciando os controladores de caso de uso do sistema
		this.ctrlDepartamentos = new CtrlManterDepartamentos(this);
		this.ctrlEmpregados = new CtrlManterEmpregados(this);
	}

	/**
	 * Procedimentos executados no início do programa
	 */
	public void iniciar(){
		// Cria e apresenta a janela principal
		this.jPrincipal = new JanelaPrincipal(this);		
		
		// Recupera os DAOs do sistema
		IDAODepartamento daoDepartamento = DAODepartamento.getSingleton();
		DAOEmpregado    daoEmpregado = DAOEmpregado.getSingleton();

		//
		// Recuperação dos objetos serializados no arquivo c:/dados.dat
		//
		try {
			// Abrindo o arquivo para leitura binária
			FileInputStream fis = new FileInputStream("c:/dados.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Solicitação para os DAOs gerenciarem os objetos recuperados do arquivo
			daoDepartamento.recuperarObjetos(ois);
			daoEmpregado.recuperarObjetos(ois);
			// Fechando o arquivo 
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo c:/dados.dat não encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Procedimentos executados no final do programa
	 */
	public void terminar(){
		// Recuperando os DAOs do sistema
		IDAODepartamento daoDepartamento = DAODepartamento.getSingleton();
		DAOEmpregado    daoEmpregado    = DAOEmpregado.getSingleton();

		try {
			// Abrindo o arquivo c:/dados.dat para escrita
			FileOutputStream fos = new FileOutputStream("c:/dados.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// Salvando os objetos gerenciados pelos DAOs
			daoDepartamento.salvarObjetos(oos);
			daoEmpregado.salvarObjetos(oos);
			// Fechando e salvando o arquivo
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		// Método estático da classe System que encerra o programa
		System.exit(0);
	}
	
	/**
	 * Procedimentos executados pelo controlador do programa
	 * para iniciar o caso de uso Manter Departamentos.
	 */
	public boolean iniciarCasoDeUsoManterDepartamentos() {
		return this.ctrlDepartamentos.iniciar();
	}
	
	/**
	 * Procedimentos executados pelo controlador do programa
	 * para finalizar o caso de uso Manter Departamentos.
	 */
	public boolean terminarCasoDeUsoManterDepartamentos() {
		return true;
	}
	
	/**
	 * Procedimentos executados pelo controlador do programa
	 * para iniciar o caso de uso Manter Empregados.
	 */
	public boolean iniciarCasoDeUsoManterEmpregados() {
		return this.ctrlEmpregados.iniciar();
	}
	
	/**
	 * Procedimentos executados pelo controlador do programa
	 * para finalizar o caso de uso Manter Empregados.
	 */
	public boolean terminarCasoDeUsoManterEmpregados() {
		return true;
	}
	
	/**
	 * O método main corresponde ao ponto inicial de execução
	 * de um programa em Java.
	 * @param args
	 */
	public static void main(String[] args) {
		CtrlPrograma prg = new CtrlPrograma();
		prg.iniciar();
	}
}
