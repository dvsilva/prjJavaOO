package controle;

public class ExemploThread extends Thread {
	
	public ExemploThread(String str){
		super(str);
		start();
	}
	
	public void run(){
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++){
			System.out.println(i + " " + getName());
		}
		System.out.println("Termina thread " + getName());
		long fim = System.currentTimeMillis();
		System.out.println("Levou" + (fim-inicio));
	}
	
	public static void main(String[] args){
		new ExemploThread("Vasco");
		new ExemploThread("Flamengo");
		new ExemploThread("Fluminense");
		new ExemploThread("Botafogo");
	}

}
