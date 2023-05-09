package tudai.prog3.main;

import tudai.prog3.colecctions.Grafo;
import tudai.prog3.colecctions.GrafoDirigido;
import tudai.prog3.recorridos.DFS;

public class Main_ej2 {
	/*
	 * Ejercicio 1. Implemente en JAVA las clases GrafoDirigido y GrafoNoDirigido.
	 */

	public static void main(String[] args) {
		Grafo<String> g = new GrafoDirigido<String>();
		String etiqueta2 = "";
		g.agregarArco(0, 1, etiqueta2);
	    g.agregarArco(0, 2, etiqueta2);
	    g.agregarArco(1, 2, etiqueta2);
	    g.agregarArco(2, 0, etiqueta2);
	    g.agregarArco(2, 3, etiqueta2);
	    g.agregarArco(3, 3, etiqueta2);	

	    System.out.println("Grafo:");
	    g.imprimir();

	    System.out.println("\nRecorrido DFS:");
	    DFS<String> dfs = new DFS<String>(g);	
	    System.out.println(dfs.getRecorrido().toString());
		
	}

}
