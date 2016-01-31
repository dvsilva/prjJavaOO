package dados;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class DAOEmpregado {
	//
	// CONSTANTES
	//
	/**
	 * Define o tamanho máximo de objetos que podem ser armazenados
	 */
	public static final int TAMANHO_MAXIMO = 20;
	
	//
	// ATRIBUTOS
	//
	/**
	 * Referência para a única instância da classe que deverá existir
	 */
	private static DAOEmpregado singleton;
	/**
	 * Referência para o array que apontará para todos os objetos 
	 * guardados pelo DAO
	 */
	private Empregado[] listaObjs;
	/**
	 * Indica o número de objetos sendo guardados pelo DAO
	 */
	private int            numObjs;
	
	//
	// MÉTODOS
	//
	/**
	 * Construtor privado do DAO
	 */
	private DAOEmpregado() {
		// Aloco memória para o array
		this.listaObjs = new Empregado[TAMANHO_MAXIMO];
		// Zero o número de objetos
		this.numObjs = 0;
	}
	
	/**
	 * Método para retornar a única instância existente do DAO
	 * @return
	 */
	public static DAOEmpregado getSingleton() {
		if(DAOEmpregado.singleton == null)
			DAOEmpregado.singleton = new DAOEmpregado();
		return DAOEmpregado.singleton;
	}
	
	/**
	 * Salva um objeto 
	 * @param novo
	 * @return
	 */
	public boolean salvar(Empregado novo){
		if(this.numObjs == TAMANHO_MAXIMO)
			return false;
		this.listaObjs[this.numObjs++] = novo;
		return true;
	}
	
	/**
	 * Remove um objeto
	 * @param obj
	 * @return
	 */
	public boolean remover(Empregado obj){
		for(int i = 0; i < TAMANHO_MAXIMO; i++){
			if(this.listaObjs[i] == obj){
				for(int j = i; j < TAMANHO_MAXIMO - 1; j++)
					this.listaObjs[j] = this.listaObjs[j+1];
				this.listaObjs[TAMANHO_MAXIMO - 1] = null;
				this.numObjs--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Promove a atualização de um objeto
	 * @param obj
	 * @return
	 */
	public boolean atualizar(Empregado obj){
		return true;
	}
	
	/**
	 * Recupera um objeto pela posição
	 * @param i
	 * @return
	 */
	public Empregado recuperar(int i){
		if(i < 0 || i >= TAMANHO_MAXIMO)
			return null;
		return this.listaObjs[i];
	}
	
	/**
	 * Recupera um objeto pelo cpf
	 * @param sigla
	 * @return
	 */
	public Empregado recuperarPeloCpf(String cpf){
		for(int i = 0; i < TAMANHO_MAXIMO; i++)
			if(this.listaObjs[i].getCpf().equals(cpf))
				return this.listaObjs[i];
		return null;
	}
	
	/**
	 * Retorna o número de objetos sendo gerenciados pelo DAO
	 * @return
	 */
	public int getNumObjs(){
		return this.numObjs;
	}

	/**
	 * Retorna uma cópia da lista de objetos
	 * @return
	 */
	public Empregado[] getListaObjs() {
		return this.listaObjs.clone();
	}
	
	/**
	 * Recupera os objetos 
	 * @return
	 */
	public void recuperarObjetos(ObjectInputStream ois) 
			throws IOException, ClassNotFoundException {
		// Recupera o numObjs
		this.numObjs = ois.readInt();
		// Recupera o array de objetos
		this.listaObjs = (Empregado[])ois.readObject();
	}

	/**
	 * Salva os objetos 
	 * @return
	 */
	public void salvarObjetos(ObjectOutputStream oos) 
			throws IOException {
		// Salva o atributo numObjs
		oos.writeInt(this.numObjs);
		// Salva o array de objetos
		oos.writeObject(this.listaObjs);
	}
}
