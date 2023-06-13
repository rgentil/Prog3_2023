package backtracking;

import java.util.ArrayList;
import java.util.List;

import coleccion.Laberinto;
import coleccion.Nodo;

/**
 * Ejercicio 2. Dado un laberinto consistente en una matriz cuadrada que tiene
 * en cada posici�n un valor natural y cuatro valores booleanos, indicando estos
 * �ltimos si desde esa casilla se puede ir al norte, este, sur y oeste,
 * encontrar un camino de longitud m�nima entre dos casillas dadas, siendo la
 * longitud de un camino la suma de los valores naturales de las casillas por
 * las que pasa. Idea: podr�a representarse el laberinto como una matriz, de
 * objetos, donde cada objeto tiene el valor natural, y cuatro booleanos, uno
 * para cada direcci�n a la que se permite ir desde all�.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private Laberinto laberinto;
	private List<Nodo> nodosVisitados;
	private Integer valorFinal;

	public Backtracking(Laberinto l) {
		this.laberinto = l;
		this.nodosVisitados = new ArrayList<Nodo>();
		this.valorFinal = null;
	}

	public List<Nodo> getCaminoMinimo(int fi, int ci, int fd, int cd) {
		List<Nodo> caminoActual = new ArrayList<Nodo>();
		List<Nodo> resultado = new ArrayList<Nodo>();
		this.valorFinal = Integer.MAX_VALUE;
		Integer valorParcial = 0;
		Nodo nodoActual = laberinto.getNodo(fi, ci);
		nodosVisitados.add(nodoActual);
		Nodo nodoDestino = laberinto.getNodo(fd, cd);
		_getCaminoMinimo(nodoActual, nodoDestino, caminoActual, resultado, valorParcial);
		return resultado;
	}

	private void _getCaminoMinimo(Nodo nodoActual, Nodo nodoDestino, List<Nodo> caminoActual, List<Nodo> resultado,
			Integer valorParcial) {

		caminoActual.add(nodoActual);
		valorParcial += nodoActual.getValor();

		if (nodoActual.equals(nodoDestino)) {
			if (valorFinal >= valorParcial) {
				valorFinal = valorParcial;
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		} else {
			for (Nodo nodoVecino : laberinto.getNodosDesde(nodoActual)) {
				int valor_para_la_poda = nodoVecino.getValor() + valorParcial;
				if (!nodosVisitados.contains(nodoVecino) && valor_para_la_poda < valorFinal) {
					nodosVisitados.add(nodoVecino);
					_getCaminoMinimo(nodoVecino, nodoDestino, caminoActual, resultado, valorParcial);
					nodosVisitados.remove(nodoVecino);

				}
			}
		}
		caminoActual.remove(nodoActual);
		valorParcial -= nodoActual.getValor();
	}
}
