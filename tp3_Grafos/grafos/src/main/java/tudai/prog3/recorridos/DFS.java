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
	private List<List<Integer>> caminos;

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
	 * inicia el recorrido desde ese v�rtice.
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
	 * Se realiza el recorrido desde un v�rtice. Se coloca el estado parcial
	 * AMARILLO. Se agrega a la soluci�n. Se recorren los v�rtices adyancente y se
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

	/**
	 * Ejercicio 3. Implemente un algoritmo que determine si un grafo dirigido tiene
	 * alg�n ciclo.
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
				if (tieneCiclos(adyacente)) {
					return true;
				}
			}
			if (colores.get(adyacente).equals("AMARILLO")) {
				return true;
			}
		}
		colores.put(vertice, "NEGRO");
		return false;
	}

	public List<List<Integer>> caminosConCiclos() {
		this.inicializarEstructura();
		caminos = new ArrayList<List<Integer>>();
		List<Integer> camino = new ArrayList<Integer>();
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			if (colores.get(vertice).equals("BLANCO")) {
				caminosConCiclos(vertice, camino);
			}
		}
		return caminos;
	}

	private void caminosConCiclos(Integer vertice, List<Integer> camino) {
		camino.add(vertice);
		colores.put(vertice, "AMARILLO");
		for (Iterator<Integer> it = grafo.obtenerAdyacentes(vertice); it.hasNext();) {
			Integer adyacente = (Integer) it.next();
			if (colores.get(adyacente).equals("BLANCO")) {
				caminosConCiclos(adyacente, camino);
			}
			if (colores.get(adyacente).equals("AMARILLO")) {
				camino.add(adyacente);
				caminos.add(new ArrayList<Integer>(camino));
				camino.remove(camino.size() - 1);
			}
		}
		camino.remove(camino.size() - 1);
		colores.put(vertice, "BLANCO");
	}

	/**
	 * Ejercicio 4. Escribir un algoritmo que, dado un grafo dirigido y dos v�rtices
	 * i, j de este grafo, devuelva el camino simple (sin ciclos) de mayor longitud
	 * del v�rtice i al v�rtice j. Puede suponerse que el grafo de entrada es
	 * ac�clico.
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
	 * @param i v�rtice de inicio
	 * @param j v�rtice final
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
	 * Ejercicio 5. Escriba un algoritmo que dado un grafo G y un v�rtice v de dicho
	 * grafo, devuelva una lista con todos los v�rtices a partir de los cuales
	 * exista un camino en G que termine en v.
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
	 * Ejercicio 6. Supongamos una conexi�n entre computadoras (1, ... ,n) que se
	 * encuentra modelada mediante un grafo. Se requiere, si existe, dar una
	 * conexi�n entre dos computadoras a y b existentes sabiendo que la computadora
	 * i est� fuera de servicio.
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
	 * Caminos : dado un origen, un destino y un l�mite retorna todos los caminos
	 * que, partiendo del v�rtice origen, llega al v�rtice de destino sin pasar por
	 * m�s de lim arcos. Aclaraci�n importante: en un camino no se puede pasar 2
	 * veces por el mismo arco.
	 */
	public List<List<Integer>> tpe_caminos(Integer origen, Integer destino, Integer lim) {
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		List<Integer> camino = new ArrayList<Integer>();
		arcos_recorridos = new ArrayList<Arco<?>>();
		_tpe_caminos(origen, destino, lim, camino, caminos);
		return caminos;
	}

	private void _tpe_caminos(Integer verticeActual, Integer destino, Integer lim_arcos, List<Integer> camino,
			List<List<Integer>> caminos) {

		camino.add(verticeActual);

		if (verticeActual.equals(destino) && arcos_recorridos.size() > 0 && arcos_recorridos.size() <= lim_arcos) {
			caminos.add(new ArrayList<Integer>(camino));
		} else {
			for (Iterator<Integer> it = grafo.obtenerAdyacentes(verticeActual); it.hasNext();) {
				Integer ady = (Integer) it.next();
				Arco<?> arco = new Arco<Integer>(verticeActual, ady, null);
				if (!arcos_recorridos.contains(arco)) {
					arcos_recorridos.add(arco);
					if (arcos_recorridos.size() <= lim_arcos) {
						_tpe_caminos(ady, destino, lim_arcos, camino, caminos);
					}
					arcos_recorridos.remove(arco);
				}
			}
		}
		camino.remove(verticeActual);
	}

	/**
	 * Ejercicio 8 Dados un grafo G con sus vértices rotulados con colores y dos
	 * vértices v1 y v2, escriba un algoritmo que encuentre un camino desde el
	 * vértice v1 al vértice v2 tal que no pase por vértices rotulados con el color
	 * rojo.
	 */
	public List<Integer> getCaminoQueNoPasePorUnColor(Grafo<String> gc, int v1, int v2, String color) {
		List<Integer> camino = new ArrayList<Integer>();
		this.inicializarEstructura();
		if (_getCaminoQueNoPasePorUnColor(gc, v1, v2, color, camino))
			return camino;
		return new ArrayList<Integer>();
	}

	private boolean _getCaminoQueNoPasePorUnColor(Grafo<String> gc, int v1, int v2, String color,
			List<Integer> camino) {

		colores.put(v1, "AMARILLO");
		camino.add(v1);
		if (v1 == v2) {
			return true;
		} else {
			for (Iterator<Arco<String>> it = gc.obtenerArcos(v1); it.hasNext();) {
				Arco<String> arcoAdy = (Arco<String>) it.next();
				Integer ady = arcoAdy.getVerticeDestino();
				String etiqueta = arcoAdy.getEtiqueta();
				if (!colores.get(ady).equals("AMARILLO") && !etiqueta.equals(color)) {
					boolean encontro = _getCaminoQueNoPasePorUnColor(gc, ady, v2, color, camino);
					if (encontro) {
						return true;
					}
				}

			}
		}
		return false;
	}

}
