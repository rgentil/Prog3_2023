package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 9. Dado un tablero de 4 x 4, en cuyas casillas se encuentran
 * desordenados los números enteros del 1 al 15 y una casilla desocupada en una
 * posición inicial dada, determinar una secuencia de pasos tal intercambiando
 * números contiguos (en horizontal y en vertical) con la casilla desocupada,
 * los números en el tablero queden ordenados (como muestra la figura) y la
 * casilla desocupada quede en la posición 4,4.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private int N;
	private Integer[][] matriz;
	private int cantidad;

	public Backtracking(Integer[][] matriz, int n) {
		this.N = n;
		this.matriz = matriz;
		this.cantidad = 0;
	}

	public Integer[][] ordenarMatriz() {
		this.cantidad = 0;
		int vacio_fila = 0;
		int vacio_columna = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matriz[i][j] == null) {
					vacio_fila = i;
					vacio_columna = j;
				}
			}
		}
		List<String> visitados = new ArrayList<String>();
		boolean resultado = _ordenarMatriz(matriz, vacio_fila, vacio_columna, visitados);

		if (resultado) {
			System.out.println("\n SOLUCIOANDO");
		} else {
			System.out.println("\n NO SE PUDO SOLUCIONAR");
		}

		System.out.println("Se intentaro " + cantidad + " veces");
		return matriz;
	}

	private boolean _ordenarMatriz(Integer[][] matriz, int vf, int vc, List<String> visitados) {

		imprimir();

		if (vf == N - 1 && vc == N - 1) {
			if (estaOrdenada(matriz)) {
				return true;
			}
		} else {
			visitados.add(vf + "," + vc);
			// Puedo ir para arriba
			if (vf > 0 && !visitados.contains((vf - 1) + "," + vc)) {
				vf -= 1;
				matriz[vf + 1][vc] = matriz[vf][vc];
				matriz[vf][vc] = null;
				boolean resultado = _ordenarMatriz(matriz, vf, vc, visitados);
				if (resultado) {
					return true;
				}
				matriz[vf][vc] = matriz[vf + 1][vc];
				matriz[vf + 1][vc] = null;
				vf += 1;
			}
			// Puedo ir para abajo
			if (vf < N - 1 && !visitados.contains((vf + 1) + "," + vc)) {
				vf += 1;
				matriz[vf - 1][vc] = matriz[vf][vc];
				matriz[vf][vc] = null;
				boolean resultado = _ordenarMatriz(matriz, vf, vc, visitados);
				if (resultado) {
					return true;
				}
				matriz[vf][vc] = matriz[vf - 1][vc];
				matriz[vf - 1][vc] = null;
				vf -= 1;
			}
			// Puedo ir para la izquierda
			if (vc > 0 && !visitados.contains(vf + "," + (vc - 1))) {
				vc -= 1;
				matriz[vf][vc + 1] = matriz[vf][vc];
				matriz[vf][vc] = null;
				boolean resultado = _ordenarMatriz(matriz, vf, vc, visitados);
				if (resultado) {
					return true;
				}
				matriz[vf][vc] = matriz[vf][vc + 1];
				matriz[vf][vc + 1] = null;
				vc += 1;
			}
			// Puedo ir para la derecha
			if (vc < N - 1 && !visitados.contains(vf + "," + (vc + 1))) {
				vc += 1;
				matriz[vf][vc - 1] = matriz[vf][vc];
				matriz[vf][vc] = null;
				boolean resultado = _ordenarMatriz(matriz, vf, vc, visitados);
				if (resultado) {
					return true;
				}
				matriz[vf][vc] = matriz[vf][vc - 1];
				matriz[vf][vc - 1] = null;
				vc -= 1;
			}
			visitados.remove(visitados.size() - 1);
		}
		return false;

	}

	private void imprimir() {
		System.out.println("\n -----------------------------------------------------------------");
		// Imprimir la matriz
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matriz[i][j] != null) {
					System.out.print(matriz[i][j] + "\t");
				} else {
					System.out.print(" \t");
				}
			}
			System.out.println();
		}

	}

	private boolean estaOrdenada(Integer[][] matriz) {

		cantidad++;

		System.out.println("\n BUSCAR SOLUCION");

		// Verificar filas
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (!(i == N - 1 && j == N - 1)) {
					if (matriz[i][j] > matriz[i][j + 1]) {
						return false;
					}
				}
			}
		}

		// Verificar columnas
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (!(i == N - 1 && j == N - 1)) {
					if (matriz[i][j] != null && matriz[i][j] > matriz[i + 1][j]) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
