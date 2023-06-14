Threads

Un thread (o hilo de ejecución), en sistemas operativos, es una característica que permite a una aplicación realizar varias
tareas a la vez (concurrentemente).

Los distintos hilos de ejecución comparten una serie de recursos tales como el espacio de memoria, los archivos abiertos, etc.

Cada hilo de ejecución tiene su propia pila de ejecución.

El uso de threads permite el diseño de aplicaciones que deben llevar a cabo distintas funciones simultáneamente. 
Por ej.: un browser de internet, mientras se descarga un archivo, muestra contenido de páginas, o ejecuta un video, etc.

Threads
	• Entonces, un thread es básicamente una tarea que puede ser ejecutada concurrentemente (o en paralelo) con otra tarea
		dentro de un mismo programa.
	
	• Los threads no pueden ejecutarse ellos solos; requieren la supervisión de un proceso padre.

	• Un proceso es un programa (o aplicación) en ejecución.

	• Dentro de cada proceso hay varios hilos ejecutándose.
		Por ejemplo, Word puede tener un hilo en background chequeando automáticamente la gramática de lo que estoy
		escribiendo, mientras otro hilo puede estar guardando automáticamente los cambios del documento en el que estoy trabajando.
	
	• Como Word, cada aplicación (proceso) puede correr varios hilos los cuales están realizando diferentes tareas.
		Esto significa que los hilos están siempre asociados con un proceso en particular.

	• Cuando se pueden ejecutar varias tareas a la vez se denomina sistema Multitarea.
	
Threads en JAVA

La JVM soporta y administra threads.

	• En Java para utilizar la multitarea tenemos dos opciones:

		1. Usar la clase Thread (es decir que la clase que implementemos debe heredar de la clase Thread). 
			La clase Thread implementa la Interface Runnable.
			Se debe redefinir el método run(). Este método es invocado cuando se inicia el hilo (mediante una llamada al método start() de la clase Thread). 
			El hilo inicia su ejecución en el método run() y termina cuando éste termina.
			El método main crea dos objetos de clase ThreadEjemplo y los inicia con la llamada al método start() (el cual inicia el nuevo hilo y llama al método run()).
			
			class ThreadEjemplo extends Thread {
				//Constructor sin asignarle nombre
				public ThreadEjemplo() {
					super();
				}
				//Constructor asignando un nombre s al thread
				public ThreadEjemplo(String	s) {
					super(s);
				}
				public void run() {
					for (int i = 0; i < 10 ; i++) {
						System.out.println(i + " soy " + getName());
					}
					System.out.println("Termina thread " + getName());
				}
			}
			
			public class Main{
				public static void main(String[] args) {
					new ThreadEjemplo("fede").start(); // fede
					new ThreadEjemplo().start(); // Thread-0
					System.out.println("Mientras el Main sigue haciendo otras cosas...");
					System.out.println("Cosa 1...");
					System.out.println("Cosa 2...");
					new ThreadEjemplo().start(); // Thread-1
					new ThreadEjemplo().start(); // Thread-2
					new ThreadEjemplo("pepe").start(); // pepe
					new ThreadEjemplo().start(); // Thread-3
					System.out.println("Cosa 3...");
					System.out.println("Termina thread main");
				}
			}

			Realizada la llamada al método start(), éste le devuelve control y continua su ejecución, independiente de los otros hilos.
			
			
		
		2. Para los casos en los que no es posible hacer que la clase definida extienda (herede) la clase Thread.
			Esto ocurre cuando en la clase que estamos definiendo (de la que se quiere ejecutar en un hilo independiente) deba extender alguna otra clase.
			Dado que no existe herencia múltiple en Java, la citada clase no puede extender a la vez la clase Thread y otra más. 
			Entonces se utiliza la opción de implementar la Interface Runnable.
			El siguiente ejemplo es equivalente al anterior, pero utilizando la interface Runnable:
			
			public class ThreadEjemplo2 implements Runnable {
				public void run() {
					for (int i = 0; i < 20 ; i++) {
						System.out.println(i + " soy " + Thread.currentThread().getName());
					}
					System.out.println("Termina thread " + Thread.currentThread().getName());
				}    
			}
			
			public class Main{
				public static void main(String[] args) {
					Thread t = new Thread(new ThreadEjemplo2());
					t.start(); // Thread-0
					new Thread(new ThreadEjemplo2()).start(); // Thread-1
					new Thread(new ThreadEjemplo2()).start(); // Thread-2
					new Thread(new ThreadEjemplo2(), "fede").start(); // fede
					System.out.println("Termina thread main");
				}
			}
			
	
	• Estados posibles de un Thread
		
		Estado de creacion, por constructor, creando una instancia. Una clase que extiende Thread o implementa Runnable.
		
		Cuando se le da al método .start() va a llamar al métod run() y se pone en estado de ejecutción. Estado llamado running.
		
		Puede que pase a un estado que se llama not running, en estado de espera. Puede ser aproposito, que yo lo ponga en ese estado o lo hace el procesador.
		Puede ser para ejecutar otro thread por ejemplo. Puede ir pasando de running a not running todo el tiempo.
		
		Y un estado Dead o fin de ejecución de ese thread.
		
	• Cualquier aplicación en ejecución (proceso) en JAVA tiene al menos un thread llamado main thread, 
		y justamente comienza su ejecución en el método main.
		
Ejemplos de ejecucion de threads
	• Ejemplo de cuentas bancarias:
		Supongamos en un banco se tienen 100 cuentas bancarias.
		Cada cuenta inicia con $2000.
		Entonces el monto total de las cuentas es $200.000.
		Se realizan sin parar operaciones de transferencia entre cuentas. De manera que lo que se saca de una cuenta se transfiere a otra. 
		Dado que las operaciones se hacen a cuentas dentro del mismo banco, la suma total $200.000 permanece constante.
		Vamos a similar esto mediante Threads que realicen aleatoriamente las operaciones de extracción.
	
	PROBLEMA: se requiere un acceso sincronizado al método que modifica las cuentas bancarias.
	
	Para esto usamos la instrucción SYNCRONIZED. Para que se esperen los threads. No corte un thread que no haya terminado para empezar con otro. 
		No solaparse entre threads.
	
	No permito que halla mas de un trheads llamando a ese método:
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		...
	}
	
	• Ejemplo Productor/Consumidor:
		El productor genera un flujo de datos que son recogidos por el consumidor
		
		PRODCUTOR ---> [---BUFFER---] ---> CONSUMIDOR

	PROBLEMA: Si no se sincronizan entre ambos puede pasar que el producto este listo para producir algo nuevo y el consumidor no haya procesado lo anterior. 
		O puede pasar que el consumidor intente consumir cuando el productor aun no se produjo. Por ejemplo Netflix, cuando se esta stremeando, tengo cargando el video 
		en un buffer. Hasta que el buffer no se llena hasta una determinada cantidad no muestra nada.
	
	public class EjemploProductorConsumidor {

		public static void main(String[] args) {
			Buffer b = new Buffer();
			Productor p = new Productor(b, "productor");
			Consumidor c = new Consumidor(b, "consumidor");
			p.start();//Se ejecutan al mismo tiempo los threads. Pero con wait() y notifyAll() controlo la ejecución
			c.start();

		}

	}

	public class Productor extends Thread {
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

	public class Consumidor extends Thread {
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

	public class Buffer {
		private char contenido;
		private boolean disponible = false;

		public Buffer() {
		}

		//Siempre que use wait y notifyAll el método es synchronized
		public synchronized char sacar() {
			char aux;
			if (!disponible) {
				try {
					System.out.println("wait sacar: " + Thread.currentThread().getName());
					wait();//Pone en espera al trhead que me llamo. Estado not running
				} catch (InterruptedException ex) {
				}
			}
			disponible = false;
			aux = contenido;
			contenido = ' ';
			System.out.println("Sacar: " + aux);
			notifyAll();//Avisa que terminó y despierta a todos los trheads que estaban esperando. Que estaban en estado not running.
			return aux;
		}

		public synchronized void poner(char valor) {
			if (disponible) {
				try {
					System.out.println("wait poner: " + Thread.currentThread().getName());
					wait();//Pone en espera al trhead que me llamo. Estado not running
				} catch (InterruptedException ex) {
				}
			}
			contenido = valor;
			disponible = true;
			System.out.println("Poner: " + valor);
			notifyAll();//Avisa que terminó y despierta a todos los trheads que estaban esperando. Que estaban en estado not running.
		}
	}


• Como vimos en muchas ocasiones será necesario sincronizar la ejecución de los threads, se da cuando varios threads acceden a un mismo recurso compartido. El banco.

• En los ejemplos vimos la utilización de la instrucción SYNCRONIZED, la cual puede utilizarse en conjunción con WAIT y NOTIFY.

• Existen otras instrucciones y técnicas para sincronizar Threads.

• Java agrega una API de mayor nivel para el manejo de threads de forma más transparente mediante el package java.util.concurrent 
	y la definición de Executors. Aquí se evita al programador tener que crear explícitamente los threads por ejemplo.

• Muy recomendado si se quiere profundizar en el tema ir a la siguiente referencia (JDK 8!):
	https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
