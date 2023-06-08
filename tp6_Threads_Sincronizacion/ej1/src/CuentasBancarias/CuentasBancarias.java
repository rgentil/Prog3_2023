package CuentasBancarias;

public class CuentasBancarias {

	public static void main(String[] args) {

		Banco b = new Banco();
		
		for(int i=0;i<100;i++) {
			
			EjecucionTransferencias r = new EjecucionTransferencias(b,i,2000);
			
			Thread t = new Thread(r);
			
			t.start();
		}

	}

}

class Banco {
  
	public Banco() {
		cuentas = new double[100];
		for (int i=0; i<cuentas.length; i++)
			cuentas[i] = 2000;   /// asigno los $2000 iniciales a cada cuenta
	}
	
	/// para sincronizar el método agregar instrucción synchronized
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
	//método sin sincronizar
	//public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
		if (cuentas[cuentaOrigen] < cantidad) {  //no puede salir mas dinero que el que tiene la cta
			return;
		}
		
		System.out.println(Thread.currentThread());
		
		cuentas[cuentaOrigen] -= cantidad;  // dinero sale de la cuenta origen
		
		System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);
		
		cuentas[cuentaDestino] += cantidad; //dinero se suma a la cuenta destino
		
		System.out.printf("Saldo Total: %10.2f%n", getSaldoTotal());
		
	}
	
	public double getSaldoTotal() {
		
		double suma=0;
		
		for(double a: cuentas)
			suma += a;
		
		return suma;
	}
	
	private double cuentas[];  
}


class EjecucionTransferencias implements Runnable{
	
	public EjecucionTransferencias(Banco b, int de, double max) {
		banco = b;
		deLaCuenta = de;
		cantidadMax = max;
	}
	
	public void run() {
		
	try {
				
		while(true) {
			int paraLaCuenta = (int)(100*Math.random());
			
			double cantidad = cantidadMax*Math.random();
			
			banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			
			Thread.sleep((int)(10*Math.random()));
			
		}
	}catch(InterruptedException e) {}
		
	}
	
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
}