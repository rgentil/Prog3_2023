package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 11 El robot de limpieza necesita volver desde su posici�n actual
 * hasta su base de carga.
 * 
 * Dado que al robot le queda poca bater�a, desea encontrar el camino m�s corto.
 * 
 * El robot dispone de un mapa de la casa representado como una matriz, donde
 * cada celda es una posici�n de la casa. La matriz posee un 0 si la celda est�
 * vac�a, o un 1 si la celda presenta alg�n obst�culo (por ejemplo, un mueble).
 * 
 * Se desea encontrar entonces el camino m�s corto considerando que: - Desde una
 * celda solo te puedes mover a las celdas contiguas (izquierda, derecha, arriba
 * y abajo) - El robot s�lo puede caminar por celdas libres (no por celdas con
 * obst�culos)
 * 
 * �Hay alguna poda que se pueda aplicar al algoritmo?
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	// Casa es una matriz de n x n en d�nde hay una celda con la posicion inicial
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
			for (Celda celda : casa.getCeldasHabilitadas()) {// Ac� va la poda, me da una lista solo con las seldas
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
