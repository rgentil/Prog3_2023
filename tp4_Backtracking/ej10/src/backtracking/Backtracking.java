package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 10 Utilizando la técnica Backtraking, escriba un algoritmo que dado
 * un conjunto de números enteros, devuelva (si existen) todos los subconjuntos
 * de tamaño N (dado como parámetro), cuyas sumas sean exactamente cero. Por
 * ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos
 * que suman cero son: {-7, -1, 8} y {-3, -2, 5}.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private List<Integer> conjunto;
	private int N;

	public Backtracking(List<Integer> conjunto, int N) {
		this.conjunto = conjunto;
		this.N = N;
	}

	public List<List<Integer>> getSubconjuntos() {
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		_getSubconjuntos(conjunto,)
		return resultado;
	}
}
