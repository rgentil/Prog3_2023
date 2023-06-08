package main;

import greedy.Dijkstra;
import greedy.Grafo;
import greedy.GrafoDirigido;

/**
 * Ejercicio 4 Algoritmo de Dijkstra. Dado un grafo con pesos no negativos,
 * implemente el algoritmo de Dijkstra para determinar el array de distancias y
 * de predecesores en el camino más corto, desde un vértice orígen dado como
 * parámetro hacia el resto de los vértices. Una vez realizado, imprima el
 * camino más corto que se debe seguir desde el orígen hacia cada vértice.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		Grafo<Integer> grafo = new GrafoDirigido<Integer>();

		grafo.agregarArco(1, 2, 6);
		grafo.agregarArco(1, 3, 2);
		grafo.agregarArco(2, 4, 1);
		grafo.agregarArco(3, 2, 3);
		grafo.agregarArco(3, 4, 5);

		// grafo.imprimir();

		grafo.imprimirPonderado();

		Dijkstra dijkstra = new Dijkstra(grafo);

		int verticeOrigen = 1;

		System.out.println("Distances desde vertice " + verticeOrigen);
		dijkstra.dijkstra(verticeOrigen);

		dijkstra.imprimirDistancias();

		dijkstra.imprimirPadres();
	}

}
