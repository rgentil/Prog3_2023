package main;

import viajante.Grafo;
import viajante.GrafoDirigido;
import viajante.Viajante;

/**
 * Ejercicio 6 Problema del viajante. Dado un grafo ponderado de ciudades
 * conectadas todas con todas, implemente un algoritmo que brinde una
 * aproximación al problema del viajante
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		Grafo<Integer> grafo = new GrafoDirigido<Integer>();

		grafo.agregarArco(0, 1, 2);
		grafo.agregarArco(0, 2, 9);
		grafo.agregarArco(0, 3, 10);
		grafo.agregarArco(1, 2, 6);
		grafo.agregarArco(1, 3, 4);
		grafo.agregarArco(2, 3, 8);
		grafo.agregarArco(3, 2, 12);

		grafo.imprimirPonderado();

		Viajante viajante = new Viajante(grafo);
		Integer ciudad_inicial = 0;

		System.out.println("Camino del viajante desde la ciudad " + ciudad_inicial);
		for (Integer ciudad : viajante.getCaminoViajante(ciudad_inicial)) {
			System.out.print(" - " + ciudad);
		}

	}

}
