package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 7. Tablero mágico. Dado un tablero de tamaño n x n, construir un
 * algoritmo que ubique (si es posible) n*n números naturales diferentes, entre
 * 1 y un cierto k (con k>n*n), de manera tal que la suma de las columnas y de
 * las filas sea igual a S.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private Integer[][] tablero;
	private int N;
	private int K;
	private int S;
	private Integer[][] tablero_resultado;
	private List<Integer[][]> tableros_resultados;

	public Backtracking(int N, int K, int S) {
		super();
		this.N = N;
		this.S = S;
		tablero = new Integer[N][N];
		this.K = K;
		this.tablero_resultado = new Integer[N][N];
		this.tableros_resultados = new ArrayList<Integer[][]>();
	}

	public Integer[][] ubicar() {
		List<Integer> usados = new ArrayList<Integer>();
		_ubicar(usados, tablero, 0, 0);
		return tablero_resultado;
	}

	private void _ubicar(List<Integer> usados, Integer[][] tablero, int fila, int columna) {
		if (fila == N) {
			if (!esta_completo(tablero_resultado)) {
				if (verificarSuma(tablero)) {
					copiarTablero(tablero_resultado, tablero);
				}
			}
		} else {
			if (columna == N) {
				fila += 1;
				_ubicar(usados, tablero, fila, 0);
				fila -= 1;
			} else {
				for (int numero = 1; numero < K; numero++) {
					Integer n = numero;
					if (!usados.contains(n)) {
						usados.add(n);
						tablero[fila][columna] = n;

						columna += 1;
						_ubicar(usados, tablero, fila, columna);
						columna -= 1;

						tablero[fila][columna] = null;
						usados.remove(usados.size() - 1);
					}
				}
			}
		}
	}

	public List<Integer[][]> getTodosLasUbicaciones() {
		List<Integer> usados = new ArrayList<Integer>();
		_getTodosLasUbicaciones(usados, tablero, 0, 0);
		return tableros_resultados;
	}

	private void _getTodosLasUbicaciones(List<Integer> usados, Integer[][] tablero, int fila, int columna) {
		if (fila == N) {
			if (verificarSuma(tablero)) {
				Integer[][] t = new Integer[N][N];
				copiarTablero(t, tablero);
				tableros_resultados.add(t);
			}
		} else {
			if (columna == N) {
				fila += 1;
				_getTodosLasUbicaciones(usados, tablero, fila, 0);
				fila -= 1;
			} else {
				for (int numero = 1; numero < K; numero++) {
					Integer n = numero;
					if (!usados.contains(n)) {
						usados.add(n);
						tablero[fila][columna] = n;

						columna += 1;
						_getTodosLasUbicaciones(usados, tablero, fila, columna);
						columna -= 1;

						tablero[fila][columna] = null;
						usados.remove(usados.size() - 1);
					}
				}
			}
		}
	}

	private boolean verificarSuma(Integer[][] tablero) {
		int[] sumaFila = new int[N];
		int[] sumaColumna = new int[N];

		for (int fila = 0; fila < N; fila++) {
			for (int columna = 0; columna < N; columna++) {
				sumaFila[fila] += tablero[fila][columna];
				sumaColumna[columna] += tablero[fila][columna];
			}
		}

		for (int i = 0; i < N; i++) {
			if (sumaFila[i] != S || sumaColumna[i] != S) {
				return false;
			}
		}

		return true;
	}

	private void copiarTablero(Integer[][] tablero_resultado, Integer[][] tablero) {
		for (int fila = 0; fila < N; fila++) {
			for (int columna = 0; columna < N; columna++) {
				tablero_resultado[fila][columna] = tablero[fila][columna];
			}
		}

	}

	private boolean esta_completo(Integer[][] tablero) {
		for (int fila = 0; fila < N; fila++) {
			for (int columna = 0; columna < N; columna++) {
				if (tablero[fila][columna] == null) {
					return false;
				}
			}
		}
		return true;
	}

}
