package tudai.prog3.recorridos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecctions.Arco;
import tudai.prog3.colecctions.Grafo;

/*
DFS (Depth-First Search)
Recorrido en profundidad
*/

public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private List<Arco<?>> arcos_recorridos;

	/**
	 * Constructor de la clase
	 * 
	 * @param g Nuevo grafo para el recorrido.
	 */
	public DFS(Grafo<?> g) {
		this.grafo = g;
		this.colores = new HashMap<Integer, String>();
		this.arcos_recorridos = new ArrayList<Arco<?>>();
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
	 * Ejercicio 2. Implemente los recorridos Depth-First-Search y
	 * Breadth-First-Search.
	 * 
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
	 * AMARILLO. Se agrega a la solución. Se recorren los vértices adyancente y
	 * se llama recursivo con cada vertices adyacente en estado inicial, BLANCO.
	 * Cuando se recorrieron todos los adyacentes de ese vertice (sale del for) el
	 * vertice se marca en NEGRO
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

	/**
	 * Ejercicio 3. Implemente un algoritmo que determine si un grafo dirigido tiene
	 * algún ciclo.
	 */
	public boolean tieneCiclos() {
		this.inicializarEstructura();
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			if (colores.get(vertice).equals("BLANCO")) {
				if (tieneCiclos(vertice)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean tieneCiclos(Integer vertice) {
		colores.put(vertice, "AMARILLO");
		for (Iterator<Integer> it = grafo.obtenerAdyacentes(vertice); it.hasNext();) {
			Integer adyacente = (Integer) it.next();
			if (colores.get(adyacente).equals("BLANCO")) {
				tieneCiclos(adyacente);
			}
			if (colores.get(adyacente).equals("AMARILLO")) {
				return true;
			}
		}
		colores.put(vertice, "NEGRO");
		return false;
	}

	/**
	 * Ejercicio 4. Escribir un algoritmo que, dado un grafo dirigido y dos
	 * vértices i, j de este grafo, devuelva el camino simple (sin ciclos) de
	 * mayor longitud del vértice i al vértice j. Puede suponerse que el grafo
	 * de entrada es acíclico.
	 */
	public List<Integer> getCaminoSimple(Integer i, Integer j) {
		this.inicializarEstructura();
		List<Integer> caminoFinal = new ArrayList<Integer>();
		List<Integer> caminoAux = new ArrayList<Integer>();
		getCaminoSimple(i, j, caminoFinal, caminoAux);
		return caminoFinal;
	}

	private void getCaminoSimple(Integer i, Integer j, List<Integer> caminoFinal, List<Integer> caminoAux) {
		colores.put(i, "AMARILLO");
		caminoAux.add(i);
		if (i == j) {
			if (caminoFinal.size() < caminoAux.size()) {
				caminoFinal.clear();
				caminoFinal.addAll(new ArrayList<Integer>(caminoAux));
			}
		} else {
			for (Iterator<Integer> it = grafo.obtenerAdyacentes(i); it.hasNext();) {
				Integer adyacente = (Integer) it.next();
				if (colores.get(adyacente).equals("BLANCO")) {
					getCaminoSimple(adyacente, j, caminoFinal, caminoAux);
				}
			}
		}
		colores.put(i, "BLANCO");
		caminoAux.remove(caminoAux.size() - 1);
	}

	/**
	 * Variedad del ejercicio para 4 para que devuelva todos los caminos.
	 * 
	 * @param i vértice de inicio
	 * @param j vértice final
	 * @return Lista con todos los caminos posibles para llegar de i a j
	 */
	public List<List<Integer>> getCaminosSimple(Integer i, Integer j) {
		this.inicializarEstructura();
		List<List<Integer>> caminosFinal = new ArrayList<List<Integer>>();
		List<Integer> caminoAux = new ArrayList<Integer>();
		getCaminosSimple(i, j, caminosFinal, caminoAux);
		return caminosFinal;
	}

	private void getCaminosSimple(Integer i, Integer j, List<List<Integer>> caminosFinal, List<Integer> caminoAux) {
		colores.put(i, "AMARILLO");
		caminoAux.add(i);
		if (i == j) {
			caminosFinal.add(new ArrayList<Integer>(caminoAux));
		} else {
			for (Iterator<Integer> it = grafo.obtenerAdyacentes(i); it.hasNext();) {
				Integer adyacente = (Integer) it.next();
				if (colores.get(adyacente).equals("BLANCO")) {
					getCaminosSimple(adyacente, j, caminosFinal, caminoAux);
				}
			}
		}
		colores.put(i, "BLANCO");
		caminoAux.remove(caminoAux.size() - 1);
	}

	/**
	 * Ejercicio 5. Escriba un algoritmo que dado un grafo G y un vértice v de
	 * dicho grafo, devuelva una lista con todos los vértices a partir de los
	 * cuales exista un camino en G que termine en v.
	 */
	public List<List<Integer>> getCaminosTerminanEnV(int v) {
		this.inicializarEstructura();
		List<List<Integer>> caminosPorVertices = new ArrayList<List<Integer>>();
		List<List<Integer>> caminosFinales = new ArrayList<List<Integer>>();
		for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext();) {
			Integer vertice = it.next();
			caminosPorVertices.clear();
			caminosPorVertices = getCaminosSimple(vertice, v);
			for (Iterator<List<Integer>> iterator = caminosPorVertices.iterator(); iterator.hasNext();) {
				List<Integer> list = (List<Integer>) iterator.next();
				caminosFinales.add(list);
			}

		}
		return caminosFinales;
	}

	/**
	 * Ejercicio 6. Supongamos una conexión entre computadoras (1, ... ,n) que se
	 * encuentra modelada mediante un grafo. Se requiere, si existe, dar una
	 * conexión entre dos computadoras a y b existentes sabiendo que la
	 * computadora i está fuera de servicio.
	 */
	public boolean existeConeccion(int a, int b, int i) {
		this.inicializarEstructura();
		colores.put(i, "NEGRO");
		boolean existe = _existeConeccion(a, b);
		return existe;
	}

	private boolean _existeConeccion(int a, int b) {
		colores.put(a, "AMARILLO");
		if (a == b) {
			return true;
		} else {
			for (Iterator<Integer> it = grafo.obtenerAdyacentes(a); it.hasNext();) {
				Integer ady = (Integer) it.next();
				if (colores.get(ady).equals("BLANCO")) {
					_existeConeccion(ady, b);
				}
			}
		}
		return false;
	}

	/**
	 * Caminos : dado un origen, un destino y un límite retorna todos los
	 * caminos que, partiendo del vértice origen, llega al vértice de destino sin
	 * pasar por más de lim arcos. Aclaración importante: en un camino no se puede
	 * pasar 2 veces por el mismo arco.
	 */
	public List<List<Integer>> tpe_caminos(Integer origen, Integer destino, Integer lim) {
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		List<Integer> camino = new ArrayList<Integer>();
		_tpe_caminos(origen, destino, lim, 0, camino, caminos);
		return caminos;
	}

	private void _tpe_caminos(Integer origen, Integer destino, Integer lim, Integer lim_arcos, List<Integer> camino,
			List<List<Integer>> caminos) {
		camino.add(origen);
		if (origen == destino && lim_arcos <= lim) {
			caminos.add(new ArrayList<Integer>(camino));
		} else {
			for (Iterator<Integer> it = grafo.obtenerAdyacentes(origen); it.hasNext();) {
				Integer ady = (Integer) it.next();
				Arco<?> arco = new Arco<Integer>(origen, ady, null);
				if (!arcos_recorridos.contains(arco)) {
					lim_arcos++;
					arcos_recorridos.add(arco);
					_tpe_caminos(ady, destino, lim, lim_arcos, camino, caminos);
					lim_arcos--;
					arcos_recorridos.remove(arco);
				}
			}
		}
		camino.remove(origen);
	}

}
