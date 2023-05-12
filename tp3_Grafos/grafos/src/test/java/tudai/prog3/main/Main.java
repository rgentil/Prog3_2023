package tudai.prog3.main;

import tudai.prog3.colecctions.Grafo;
import tudai.prog3.colecctions.GrafoDirigido;
import tudai.prog3.recorridos.BFS;
import tudai.prog3.recorridos.DFS;

/**
 * Ejercicio 1. Implemente en JAVA las clases GrafoDirigido y GrafoNoDirigido.
 * 
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * Ejercicio 1. Implemente en JAVA las clases GrafoDirigido y GrafoNoDirigido.
		 */
		Grafo<String> g = new GrafoDirigido<String>();
		g.agregarArco(0, 1, "");
		g.agregarArco(0, 2, "");
		g.agregarArco(1, 2, "");
		g.agregarArco(2, 0, "");
		g.agregarArco(2, 3, "");
		g.agregarArco(3, 3, "");

		System.out.println("Grafo:");
		g.imprimir();

		/**
		 * Ejercicio 2. Implemente los recorridos Depth-First-Search y
		 * Breadth-First-Search.
		 */
		System.out.println("\nRecorrido DFS:");
		DFS dfs = new DFS(g);
		System.out.println(dfs.getRecorrido().toString());

		System.out.println("\nRecorrido BFS:");
		BFS bfs = new BFS(g);
		System.out.println(bfs.getRecorrido().toString());

		/**
		 * Ejercicio 3. Implemente un algoritmo que determine si un grafo dirigido tiene
		 * algún ciclo.
		 */
		System.out.println("\nComprobar si un grafo dirigido tiene algún ciclo");
		System.out.println("Tiene ciclos: " + dfs.tieneCiclos());

		/**
		 * Ejercicio 4. Escribir un algoritmo que, dado un grafo dirigido y dos vértices
		 * i, j de este grafo, devuelva el camino simple (sin ciclos) de mayor longitud
		 * del vértice i al vértice j. Puede suponerse que el grafo de entrada es
		 * acíclico.
		 */

		System.out.println("\n Camino simple (sin ciclos) de mayor longitud del vértice i al vértice j :\n"
				+ dfs.getCaminoSimple(0, 3).toString());

		System.out.println("\nTodos los caminos vértice i al vértice j :\n" + dfs.getCaminosSimple(0, 3).toString());

		/**
		 * Ejercicio 5. Escriba un algoritmo que dado un grafo G y un vértice v de dicho
		 * grafo, devuelva una lista con todos los vértices a partir de los cuales
		 * exista un camino en G que termine en v.
		 */
		System.out.println("\nTodos los caminos que terminan en V :\n" + dfs.getCaminosTerminanEnV(3).toString());
	}

}
