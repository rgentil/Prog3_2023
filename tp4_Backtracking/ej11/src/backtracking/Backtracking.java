package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 11 El robot de limpieza necesita volver desde su posición actual
 * hasta su base de carga.
 * 
 * Dado que al robot le queda poca batería, desea encontrar el camino más corto.
 * 
 * El robot dispone de un mapa de la casa representado como una matriz, donde
 * cada celda es una posición de la casa. La matriz posee un 0 si la celda está
 * vacía, o un 1 si la celda presenta algún obstáculo (por ejemplo, un mueble).
 * 
 * Se desea encontrar entonces el camino más corto considerando que: - Desde una
 * celda solo te puedes mover a las celdas contiguas (izquierda, derecha, arriba
 * y abajo) - El robot sólo puede caminar por celdas libres (no por celdas con
 * obstáculos)
 * 
 * ¿Hay alguna poda que se pueda aplicar al algoritmo?
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	// Casa es una matriz de n x n en dónde hay una celda con la posicion inicial
	// del roboto, una celda con la posicion del cargador y las celdas restantes con
	// 1 o 0 para controlar si esta ocupada la celda o no con algun obstaculo
	private Casa casa;

	public Backtracking() {
		casa = new Casa(4);
	}

	public List<Celda> getCaminoMasCorto() {
		_getCaminoMasCorto(casa);
		return casa.getCaminoMasCorto();
	}

	private void _getCaminoMasCorto(Casa casa) {
		if (casa.getPosicionRobot() == casa.getPosicionCargador()) {
			casa.compararCaminos();
		} else {
			for (Celda celda : casa.getCeldasHabilitadas()) {// Acá va la poda, me da una lista solo con las seldas
																// a las que puedo ir
				if (casa.celdaNoUsada(celda)) { // y se agrga a al poda que esa celda no haya sido visitada
					casa.agregaSelda(celda);
					casa.moverRobot(celda);
					_getCaminoMasCorto(casa); // Llamo recursivo para el nuevo estado.
					casa.volverRobot(celda);
					casa.quitarSelda(celda);
				}
			}
		}

	}
}
