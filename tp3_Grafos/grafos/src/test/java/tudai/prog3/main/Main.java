package tudai.prog3.main;

import java.util.List;

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

//		g.agregarArco(1, 1, null);
//		g.agregarArco(1, 2, null);
//		g.agregarArco(1, 3, null);	
//		g.agregarArco(3, 2, null);
//		g.agregarArco(2, 5, null);		
//		g.agregarArco(3, 4, null);
//		g.agregarArco(4, 1, null);
//		g.agregarArco(4, 5, null);

		g.agregarArco(1, 2, null);
		g.agregarArco(2, 3, null);
		g.agregarArco(3, 1, null);
		g.agregarArco(3, 4, null);

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
		 * alg�n ciclo.
		 */
		System.out.println("\nComprobar si un grafo dirigido tiene alg�n ciclo");
		System.out.println("Tiene ciclos: " + dfs.tieneCiclos());
		List<List<Integer>> caminosConCiclos = dfs.caminosConCiclos();
		System.out.println("\nCaminos con ciclo: ");
		for (List<Integer> list : caminosConCiclos) {
			System.out.println(list.toString());
		}

		/**
		 * Ejercicio 4. Escribir un algoritmo que, dado un grafo dirigido y dos v�rtices
		 * i, j de este grafo, devuelva el camino simple (sin ciclos) de mayor longitud
		 * del v�rtice i al v�rtice j. Puede suponerse que el grafo de entrada es
		 * ac�clico.
		 */

		int i = 1;
		int j = 4;
		System.out.println("\n Camino simple (sin ciclos) de mayor longitud del v�rtice " + i + " al v�rtice " + j
				+ " :\n" + dfs.getCaminoSimple(i, j).toString());

		System.out.println("\nTodos los caminos v�rtice " + i + " al v�rtice " + j + " :\n"
				+ dfs.getCaminosSimple(i, j).toString());

		/**
		 * Ejercicio 5. Escriba un algoritmo que dado un grafo G y un v�rtice v de dicho
		 * grafo, devuelva una lista con todos los v�rtices a partir de los cuales
		 * exista un camino en G que termine en v.
		 */
		int v = 4;
		System.out
				.println("\nTodos los caminos que terminan en " + v + " :\n" + dfs.getCaminosTerminanEnV(v).toString());

		/**
		 * Caminos : dado un origen, un destino y un l�mite �lim� retorna todos los
		 * caminos que, partiendo del v�rtice origen, llega al v�rtice de destino sin
		 * pasar por m�s de �lim� arcos. Aclaraci�n importante: en un camino no se puede
		 * pasar 2 veces por el mismo arco.
		 */
		int origen = 1;
		int destino = 4;
		int lim = 10;

		System.out.println("\nTPE \n Origen: " + origen + " \n" + " Desino: " + destino + " \n Limite: " + lim + "\n");

		List<List<Integer>> caminos = dfs.tpe_caminos(origen, destino, lim);
		System.out.println("\nCaminos: ");
		for (List<Integer> list : caminos) {
			System.out.println(list.toString());
		}

		/**
		 * Ejercicio 8 Dados un grafo G con sus vértices rotulados con colores y dos
		 * vértices v1 y v2, escriba un algoritmo que encuentre un camino desde el
		 * vértice v1 al vértice v2 tal que no pase por vértices rotulados con el color
		 * rojo.
		 */
		Grafo<String> gc = new GrafoDirigido<String>();
		gc.agregarArco(1, 2, "rojo");
		gc.agregarArco(1, 3, "");
		gc.agregarArco(2, 3, "");
		gc.agregarArco(3, 1, "");
		gc.agregarArco(3, 4, "");

		gc.imprimirPonderado();
		int v1 = 1;
		int v2 = 4;
		String color = "rojo";
		System.out.println("\n Camino que no pase por " + color + " desde " + v1 + " al v�rtice " + v2 + " :\n"
				+ dfs.getCaminoQueNoPasePorUnColor(gc, i, j, color).toString());

		/**
		 * Dado un grafo dirigido, el cual contiene un solo ciclo, determine si, en caso
		 * de que tenga un ciclo, la suma de los arcos del ciclo resulta ser igual a un
		 * valor X dados como parametro.
		 */
		Grafo<Integer> grafo1 = new GrafoDirigido<Integer>();

		grafo1.agregarArco(1, 2, 7);
		grafo1.agregarArco(1, 3, 3);
		grafo1.agregarArco(2, 3, 1);
		grafo1.agregarArco(2, 4, 6);
		grafo1.agregarArco(3, 5, 8);
		grafo1.agregarArco(4, 3, 3);
		grafo1.agregarArco(4, 6, 2);
		grafo1.agregarArco(5, 4, 2);
		grafo1.agregarArco(5, 6, 8);

		System.out.println("Grafo del parcial :");
		grafo1.imprimir();
		DFS dfs1 = new DFS(grafo1);
		boolean resultado = dfs1.tieneCicloConSumaIgualAN(13);
		System.out.println("Tiene ciclo con suma igual a 13 " + resultado);
	}

}
