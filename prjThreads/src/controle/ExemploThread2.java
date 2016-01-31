package controle;

public class ExemploThread2 implements Runnable {
	
	private Thread minhaThread;
	
	public ExemploThread2(String str){
		this.minhaThread = new Thread (this, str);
		this.minhaThread.start();
	}
	
	public void run(){
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++){
			System.out.println(i + " " + minhaThread.getName());
		}
		System.out.println("Termina thread " + minhaThread.getName());
		long fim = System.currentTimeMillis();
		System.out.println("Levou" + (fim-inicio));
	}
	
	public static void main(String[] args){
		new ExemploThread2("Vasco");
		new ExemploThread2("Flamengo");
		new ExemploThread2("Fluminense");
		new ExemploThread2("Botafogo");
	}

}
