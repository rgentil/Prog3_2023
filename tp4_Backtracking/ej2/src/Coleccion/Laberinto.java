package Coleccion;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("Laberinto ["+N+"]["+N+"] : ");
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
