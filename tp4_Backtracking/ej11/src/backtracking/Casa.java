package backtracking;

import java.util.List;

public class Casa {

	private int N;
	private Celda[][] espacios;

	public Casa(int N) {
		this.N = N;
		espacios = new Celda[N][N];
	}

	public List<Celda> getCaminoMasCorto() {
		// Retorno el camino generado
		return null;
	}

	public void compararCaminos() {
		// Si no hay un camino agrega ese camino, si hay un camino ya encontrado, lo
		// compara con el nuevo camino que se genero

	}

	public Celda getPosicionRobot() {
		// Retorna la posicion actual del robot, en que celda está actualmente
		return null;
	}

	public Celda getPosicionCargador() {
		// Celda en al cual se encontra el cargador
		return null;
	}

	public Celda[] getCeldasHabilitadas() {
		// Me da un listado de celda que estan habilitadas, en 0, y pueda moverme
		// horizontal o
		// verticalmente para generar un nuevo estado.
		return null;
	}

	public boolean celdaNoUsada(Celda celda) {
		// Controla si ya se ha pasado por esa celdaS
		return false;
	}

	public void agregaSelda(Celda celda) {
		// Agrega la selda al posible camino solucion

	}

	public void moverRobot(Celda celda) {
		// Mueve el robot a la celda siguiente que corresponde.

	}

	public void volverRobot(Celda celda) {
		// Vuelvo el robot a la celda para probar otros caminos posibles.

	}

	public void quitarSelda(Celda celda) {
		// Quita la celda del posible camino solucion para probar estos estados.

	}

}
