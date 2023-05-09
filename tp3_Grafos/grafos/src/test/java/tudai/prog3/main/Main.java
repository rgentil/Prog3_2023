package tudai.prog3.main;

import tudai.prog3.colecctions.Grafo;
import tudai.prog3.colecctions.GrafoDirigido;
import tudai.prog3.recorridos.BFS;
import tudai.prog3.recorridos.DFS;

/**
 * Ejercicio 1. Implemente en JAVA las clases GrafoDirigido y GrafoNoDirigido.
 * Ejercicio 2. Implemente los recorridos Depth-First-Search y
 * Breadth-First-Search.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		Grafo<String> g = new GrafoDirigido<String>();
		g.agregarArco(0, 1, "");
		g.agregarArco(0, 2, "");
		g.agregarArco(1, 2, "");
		g.agregarArco(2, 0, "");
		g.agregarArco(2, 3, "");
		g.agregarArco(3, 3, "");

		System.out.println("Grafo:");
		g.imprimir();

		System.out.println("\nRecorrido DFS:");
		DFS dfs = new DFS(g);
		System.out.println(dfs.getRecorrido().toString());

		System.out.println("\nRecorrido BFS:");
		BFS bfs = new BFS(g);
		System.out.println(bfs.getRecorrido().toString());

	}

}
