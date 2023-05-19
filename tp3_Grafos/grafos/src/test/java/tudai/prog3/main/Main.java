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
//		g.agregarArco(3, 8, "");
//		g.agregarArco(3, 10, "");
//		g.agregarArco(5, 11, "");
//		g.agregarArco(7, 11, "");
//		g.agregarArco(7, 8, "");	
//		g.agregarArco(8, 9, "");
//		g.agregarArco(11, 2, "");
//		g.agregarArco(11, 9, "");
//		g.agregarArco(11, 10, "");
//		g.agregarArco(11, 8, "");
//		
		
		g.agregarArco(1, 2, null);
		g.agregarArco(1, 3, null);
		g.agregarArco(2, 5, null);
		g.agregarArco(3, 4, null);
		g.agregarArco(4, 5, null);
		
		//Ciclo
		g.agregarArco(4, 1, null);
		
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

		int i = 11;
		int j = 11;
		System.out.println("\n Camino simple (sin ciclos) de mayor longitud del vértice "+i+" al vértice "+j+" :\n"
				+ dfs.getCaminoSimple(i, j).toString());

		System.out.println("\nTodos los caminos vértice "+i+" al vértice "+j+" :\n" + dfs.getCaminosSimple(i, j).toString());

		/**
		 * Ejercicio 5. Escriba un algoritmo que dado un grafo G y un vértice v de dicho
		 * grafo, devuelva una lista con todos los vértices a partir de los cuales
		 * exista un camino en G que termine en v.
		 */
		int v = 11;
		System.out.println("\nTodos los caminos que terminan en "+v+" :\n" + dfs.getCaminosTerminanEnV(v).toString());
	}

}
