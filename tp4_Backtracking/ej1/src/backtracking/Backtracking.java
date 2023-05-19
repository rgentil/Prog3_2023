package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import collections.Grafo;

/**
 * Ejercicio 1. Se tiene un conjunto de salas comunicadas entre sí a través de
 * puertas que se abren solamente en un sentido. Una de las salas se denomina
 * entrada y la otra salida. Construir un algoritmo que permita ir desde la
 * entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
 * representar el problema mediante un grafo dirigido, donde cada nodo es una
 * habitación, y cada puerta es un arco dirigido hacia otra habitación.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private HashMap<Integer, String> estado;
	private Grafo<Integer> salas;

	public Backtracking(Grafo<Integer> g) {
		this.salas = g;
		estado = new HashMap<Integer, String>();
	}

	private void inicializarSalas() {
		for (Iterator<Integer> it = salas.obtenerVertices(); it.hasNext();) {
			Integer sala = (Integer) it.next();
			estado.put(sala, "INICIAL");
		}
	}

	public List<Integer> getSalida(Grafo<Integer> salas, int entrada, int salida) {
		this.inicializarSalas();
		List<Integer> resultado = new ArrayList<Integer>();
		List<Integer> parcial = new ArrayList<Integer>();
		_getSalida(salas, entrada, salida, parcial, resultado);
		return resultado;
	}

	private void _getSalida(Grafo<Integer> salas, int salaActual, int salida, List<Integer> parcial,
			List<Integer> resultado) {
		parcial.add(salaActual);
		estado.put(salaActual, "PARCIAL");
		if (salaActual == salida) {
			if (parcial.size() > resultado.size()) {
				resultado.clear();
				resultado.addAll(parcial);
			}
		} else {
			for (Iterator<Integer> it = salas.obtenerAdyacentes(salaActual); it.hasNext();) {
				Integer ady = (Integer) it.next();
				if (estado.get(ady).equals("INICIAL")) {
					_getSalida(salas, ady, salida, parcial, resultado);
				}
			}			
		}
		estado.put(salaActual, "INICIAL");
		parcial.remove(parcial.size() - 1);

	}
}
