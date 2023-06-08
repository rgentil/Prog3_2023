package greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class Dijkstra {

	Grafo<Integer> grafo;
	Integer[] distancias;
	Integer[] padres;
	List<Integer> visitados;

	public Dijkstra(Grafo<Integer> grafo) {
		this.grafo = grafo;
		visitados = new ArrayList<Integer>();
		distancias = new Integer[grafo.cantidadVertices() + 1];
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}
		padres = new Integer[grafo.cantidadVertices() + 1];
		for (int i = 0; i < padres.length; i++) {
			padres[i] = null;
		}
	}

	public void dijkstra(int origen) {
		distancias[origen] = 0; // Distancia desde el origen es cero.
		padres[origen] = 0;// Para setear el padre con algo.
		Integer vertice_actual = origen;
		visitados.add(vertice_actual);
		while (visitados.size() < grafo.cantidadVertices()) {
			for (Iterator<Arco<Integer>> it = grafo.obtenerArcos(vertice_actual); it.hasNext();) {
				Arco<Integer> arcoAdy = it.next();
				Integer ady = arcoAdy.getVerticeDestino();
				Integer peso = arcoAdy.getEtiqueta();
				if (!visitados.contains(ady) && distancias[vertice_actual] + peso <= distancias[ady]) {
					distancias[ady] = distancias[vertice_actual] + peso;
					padres[ady] = vertice_actual;
				}
			}
			vertice_actual = getVerticeMenor(distancias);
			visitados.add(vertice_actual);
		}

	}

	private Integer getVerticeMenor(Integer[] distancias) {
		int peso = Integer.MAX_VALUE;
		int vertice_menor = Integer.MAX_VALUE;
		for (int i = 1; i <= distancias.length - 1; i++) {
			Integer peso_vertice = distancias[i];
			Integer vertice = i;
			if (!visitados.contains(vertice) && peso_vertice < peso) {
				peso = peso_vertice;
				vertice_menor = vertice;
			}
		}
		return vertice_menor;
	}

	public void imprimirDistancias() {
		System.out.println("Distancias");
		for (int i = 1; i < distancias.length; i++) {
			System.out.println("Vertice " + i + ": " + distancias[i]);
		}
	}

	public void imprimirPadres() {
		System.out.println("Padres");
		for (int i = 1; i < padres.length; i++) {
			System.out.println("Padre de " + i + ": " + padres[i]);
		}
	}

}
