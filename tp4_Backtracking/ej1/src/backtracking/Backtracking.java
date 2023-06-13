package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import collections.Grafo;

/**
 * Ejercicio 1. Se tiene un conjunto de salas comunicadas entre s� a trav�s de
 * puertas que se abren solamente en un sentido. Una de las salas se denomina
 * entrada y la otra salida. Construir un algoritmo que permita ir desde la
 * entrada a la salida atravesando la m�xima cantidad de salas. Idea: podr�a
 * representar el problema mediante un grafo dirigido, donde cada nodo es una
 * habitaci�n, y cada puerta es un arco dirigido hacia otra habitaci�n.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private HashMap<Integer, Boolean> recorrida;
	private Grafo<Integer> salas;

	public Backtracking(Grafo<Integer> g) {
		this.salas = g;
		recorrida = new HashMap<Integer, Boolean>();
	}

	private void inicializarSalas() {
		for (Iterator<Integer> it = salas.obtenerVertices(); it.hasNext();) {
			Integer sala = (Integer) it.next();
			recorrida.put(sala, false);
		}
	}

	public List<Integer> getSalida(int entrada, int salida) {
		this.inicializarSalas();
		List<Integer> resultado = new ArrayList<Integer>();
		List<Integer> parcial = new ArrayList<Integer>();
		_getSalida(entrada, salida, parcial, resultado);
		return resultado;
	}

	private void _getSalida(int salaActual, int salida, List<Integer> parcial, List<Integer> resultado) {
		parcial.add(salaActual);
		recorrida.put(salaActual, true);
		if (salaActual == salida) {
			if (parcial.size() > resultado.size()) {
				resultado.clear();
				resultado.addAll(parcial);
			}
		} else {
			for (Iterator<Integer> it = salas.obtenerAdyacentes(salaActual); it.hasNext();) {
				Integer ady = (Integer) it.next();
				if (!recorrida.get(ady)) {
					_getSalida(ady, salida, parcial, resultado);
				}
			}
		}
		recorrida.put(salaActual, false);
		parcial.remove(parcial.size() - 1);

	}
}
