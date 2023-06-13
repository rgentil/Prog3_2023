package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 4. Partici�n de conjunto. Dado un conjunto de n enteros se desea
 * encontrar, si existe, una partici�n en dos subconjuntos disjuntos, tal que la
 * suma de sus elementos sea la misma.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private List<Integer> numeros;
	private List<Integer> conjunto1;
	private List<Integer> conjunto2;

	public Backtracking(List<Integer> numeros) {
		this.numeros = numeros;
		this.conjunto1 = new ArrayList<Integer>();
		this.conjunto2 = new ArrayList<Integer>();
	}

	public List<List<Integer>> getSubConjuntosDisjuntosIguales() {
		this.conjunto1 = new ArrayList<Integer>();
		this.conjunto2 = new ArrayList<Integer>();
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		_getSubConjuntosDisjuntosIguales(numeros, conjunto1, conjunto2, resultado);
		return resultado;
	}

	private void _getSubConjuntosDisjuntosIguales(List<Integer> numeros, List<Integer> conjunto1,
			List<Integer> conjunto2, List<List<Integer>> resultado) {
		if (resultado.isEmpty()) {
			if (numeros.isEmpty()) {
				if (suma(conjunto1) == suma(conjunto2)) {
					resultado.add(new ArrayList<Integer>(conjunto1));
					resultado.add(new ArrayList<Integer>(conjunto2));
				}
			} else {
				// La disicion es ponerlo en el conjunto 1 o el 2
				Integer numero = numeros.remove(numeros.size() - 1);
				
				conjunto1.add(numero);
				_getSubConjuntosDisjuntosIguales(numeros, conjunto1, conjunto2, resultado);
				conjunto1.remove(conjunto1.size() - 1);

				conjunto2.add(numero);
				_getSubConjuntosDisjuntosIguales(numeros, conjunto1, conjunto2, resultado);
				conjunto2.remove(conjunto2.size() - 1);
				
				numeros.add(numero);
			}
		}
	}

	private int suma(List<Integer> conjunto) {
		int sum = 0;
		for (int n : conjunto) {
			sum += n;
		}
		return sum;
	}

}
