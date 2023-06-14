package ProductorConsumidor;

//Buffer Sin Sincronizar
/*
class Buffer {
	  private char contenido;
	  private boolean disponible=false;
	  
	  public Buffer() {
	  }
	  
	  public char sacar(){
		char aux;
	    if(disponible){
	        disponible=false;
	        aux=contenido;
	        contenido=' ';
	        System.out.println("Sacar: " +aux);
	        return aux;
	    }
	    System.out.println("Sacar: " +' ');
	    return (' ');
	  }
	  
	  public void poner(char c){
	    contenido=c;
	    System.out.println("Poner: " +c);
	    disponible=true;
	  }        
	  
	}
*/

//Buffer Sincronizado
//

class Buffer {
	private char contenido;
	private boolean disponible = false;

	public Buffer() {
	}

	public synchronized char sacar() {
		char aux;
		if (!disponible) {
			try {
				System.out.println("wait sacar: " + Thread.currentThread().getName());
				wait();
			} catch (InterruptedException ex) {
			}
		}
		disponible = false;
		aux = contenido;
		contenido = ' ';
		System.out.println("Sacar: " + aux);
		notifyAll();
		return aux;
	}

	public synchronized void poner(char valor) {
		if (disponible) {
			try {
				System.out.println("wait poner: " + Thread.currentThread().getName());
				wait();
			} catch (InterruptedException ex) {
			}
		}
		contenido = valor;
		disponible = true;
		System.out.println("Poner: " + valor);
		notifyAll();
	}
}

//

class Productor extends Thread {
	private Buffer buffer;
	private final String letras = "abcdefghijklmnopqrstuvxyz";

	public Productor(Buffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			char c = letras.charAt((int) (Math.random() * letras.length()));
			buffer.poner(c);
			try {
				sleep(50);
			} catch (InterruptedException s) {
			}

		}
	}
}

class Consumidor extends Thread {
	private Buffer buffer;

	public Consumidor(Buffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		char valor;
		for (int i = 0; i < 10; i++) {
			valor = buffer.sacar();
			try {
				sleep(100);
			} catch (InterruptedException s) {
			}
		}
	}
}

public class EjemploProductorConsumidor {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		Productor p = new Productor(b, "productor");
		Consumidor c = new Consumidor(b, "consumidor");
		p.start();
		c.start();

	}

}
