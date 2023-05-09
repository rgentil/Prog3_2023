package tudai.prog3.recorridos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecctions.Grafo;

/*
DFS (Depth-First Search)
Recorrido en profundidad
*/

public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;

	/**
	 * Constructor de la clase
	 * 
	 * @param g Nuevo grafo para el recorrido.
	 */
	public DFS(Grafo<?> g) {
		this.grafo = g;
		this.colores = new HashMap<Integer, String>();
	}

	/**
	 * Inicializa el hash con los vertices todos en blanco. Key = vertice, Value un
	 * color. BLANCO = Estado inicial. AMARILLO = Estado intermedio. ROJO = Estado
	 * final.
	 */
	private void inicializarEstructura() {
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			colores.put(vertice, "BLANCO");
		}
	}

	/**
	 * Inicializa la estrucutra. Complejidad O(|V|+|A|). Va a pasar una vez por cada
	 * vertice y una vez por cada arco. Recorre todos los vertices que no hayan sido
	 * ni visitados ni tengo un estado final. O sea, que sea BLANCO. Entonces si
	 * inicia el recorrido desde ese vértice.
	 * 
	 * @return Lista del recorrido
	 */
	public List<Integer> getRecorrido() {
		this.inicializarEstructura();
		List<Integer> resultado = new ArrayList<Integer>();
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			if (colores.get(vertice).equals("BLANCO")) {
				resultado.addAll(getRecorrido(vertice));
			}
		}
		return resultado;
	}

	/**
	 * Se realiza el recorrido desde un vértice. Se coloca el estado parcial
	 * AMARILLO. Se agrega a la solución. Se recorren los vértices adyancente y se
	 * llama recursivo con cada vertices adyacente en estado inicial, BLANCO. Cuando
	 * se recorrieron todos los adyacentes de ese vertice (sale del for) el vertice
	 * se marca en NEGRO
	 * 
	 * @param vertice punto de partida
	 * @return lista de camino
	 */
	private List<Integer> getRecorrido(Integer vertice) {
		List<Integer> resultado = new ArrayList<Integer>();
		colores.put(vertice, "AMARILLO");
		resultado.add(vertice);
		for (Iterator<Integer> it = grafo.obtenerAdyacentes(vertice); it.hasNext();) {
			Integer adyacente = (Integer) it.next();
			if (colores.get(adyacente).equals("BLANCO")) {
				resultado.addAll(getRecorrido(adyacente));
			}
		}
		colores.put(vertice, "NEGRO");
		return resultado;
	}

}
