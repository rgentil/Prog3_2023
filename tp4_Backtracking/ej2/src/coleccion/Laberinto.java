package coleccion;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 2. Dado un laberinto consistente en una matriz cuadrada que tiene
 * en cada posición un valor natural y cuatro valores booleanos, indicando estos
 * últimos si desde esa casilla se puede ir al norte, este, sur y oeste,
 * encontrar un camino de longitud mínima entre dos casillas dadas, siendo la
 * longitud de un camino la suma de los valores naturales de las casillas por
 * las que pasa. Idea: podría representarse el laberinto como una matriz, de
 * objetos, donde cada objeto tiene el valor natural, y cuatro booleanos, uno
 * para cada dirección a la que se permite ir desde allí.
 * 
 * @author Gentil Ricardo
 *
 */
public class Laberinto {

	private Nodo[][] laberinto;
	private int N;

	public Laberinto(int n) {
		super();
		this.N = n;
		laberinto = new Nodo[N][N];
	}

	public void inertarNodo(Nodo nodo) {
		laberinto[nodo.getFila()][nodo.getColumna()] = nodo;
	}

	public void imprimir() {
		System.out.println("Laberinto [" + N + "][" + N + "] : ");
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.print("   " + laberinto[i][j].getNombre() + "-" + laberinto[i][j].getValor() + " ");
			}
			System.out.println();
		}
	}

	public Nodo getNodo(int f, int c) {
		return laberinto[f][c];
	}

	public List<Nodo> getNodosDesde(Nodo nodoActual) {
		List<Nodo> nodos = new ArrayList<Nodo>();
		if (nodoActual.puede_ir_Norte()) {
			nodos.add(this.getNodo(nodoActual.getFila() - 1, nodoActual.getColumna()));
		}
		if (nodoActual.puede_ir_Sur()) {
			nodos.add(this.getNodo(nodoActual.getFila() + 1, nodoActual.getColumna()));
		}
		if (nodoActual.puede_ir_Este()) {
			nodos.add(this.getNodo(nodoActual.getFila(), nodoActual.getColumna() + 1));
		}
		if (nodoActual.puede_ir_Oeste()) {
			nodos.add(this.getNodo(nodoActual.getFila(), nodoActual.getColumna() - 1));
		}
		return nodos;

	}
}
