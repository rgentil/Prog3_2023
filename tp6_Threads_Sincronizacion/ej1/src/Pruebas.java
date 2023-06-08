
public class Pruebas {

////ThreadEjemplo extendiendo Thread
/*	public static void main(String[] args) {
	    new ThreadEjemplo("fede").start();	 //fede   
        new ThreadEjemplo().start();  //Thread-0
        System.out.println("Mientras el Main sigue haciendo otras cosas...");
        System.out.println("Cosa 1...");
        System.out.println("Cosa 2...");
        new ThreadEjemplo().start();  //Thread-1
        new ThreadEjemplo().start();   //Thread-2
        new ThreadEjemplo("pepe").start();  //pepe
        new ThreadEjemplo().start();   //Thread-3
        System.out.println("Cosa 3...");
        System.out.println("Termina thread main");
        
    }
*/
	
   ////ThreadEjemplo2 implementando Runnable
	 public static void main (String [] args) {
	
	Thread t = new Thread ( new ThreadEjemplo2());
    t.start();  //Thread-0
    
	new Thread ( new ThreadEjemplo2()).start();  //Thread-1
	new Thread ( new ThreadEjemplo2()).start();  //Thread-2
	new Thread ( new ThreadEjemplo2(), "fede").start();  //fede      
	System.out.println("Termina thread main");
	} 
	
}












































