package tudai.prog3.recorridos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecctions.Grafo;

/*
Breadth First Search
Recorrido por amplitud
*/
public class BFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitados;

	public BFS(Grafo<?> g) {
		this.grafo = g;
		this.visitados = new HashMap<Integer, Boolean>();
	}

	/**
	 * Inicio todos los vertices como no visitados.
	 */
	private void iniciarEstructura() {
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			visitados.put(vertice, false);

		}
	}

	/**
	 * Ejercicio 2. Implemente los recorridos Depth-First-Search y
	 * Breadth-First-Search.
	 * 
	 * Inicio la estructura. Recorro todos los vertices que no fueron vistados.
	 * O(|V|+|A|). Va a pasar una vez por cada vertice y una vez por cada arco.
	 * 
	 * @return
	 */
	public List<Integer> getRecorrido() {
		this.iniciarEstructura();
		List<Integer> resultado = new ArrayList<Integer>();
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			if (!visitados.get(vertice)) {
				resultado.addAll(getRecorrido(vertice));
			}
		}
		return resultado;
	}

	/**
	 * Marcar el vértice origen como VISITADO y lo agrego a la fila. Tomo el primer
	 * vertice de la fila y recorro todos los adyacentes que no fueron visitados y
	 * los voy marcando agregando a la salida para visitarlos a todos y al final
	 * para mostrarlo como solución
	 * 
	 * @param origen Vertice origen
	 * @return
	 */
	private List<Integer> getRecorrido(Integer origen) {
		ArrayList<Integer> fila = new ArrayList<>();
		ArrayList<Integer> salida = new ArrayList<>();
		visitados.put(origen, true);
		fila.add(origen);
		salida.add(origen);
		while (!fila.isEmpty()) {
			int vertice = fila.remove(0);
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (!visitados.get(adyacente)) {
					visitados.put(adyacente, true);
					fila.add(adyacente);
					salida.add(adyacente);
				}
			}
		}
		return salida;
	}

}
