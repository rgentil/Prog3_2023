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
		List<Integer> parcial = new ArrayList<Integer>();
		List<Integer> usado = new ArrayList<Integer>();
		boolean encontro = _getSubconjuntos(conjunto, usado, parcial, resultado);
		if (encontro) {
			System.out.print("\n\n Hay resultado");
		} else {
			System.out.print("\n\n No se encontró resultado");
		}

		return resultado;
	}

	private boolean _getSubconjuntos(List<Integer> conjunto, List<Integer> usado, List<Integer> parcial,
			List<List<Integer>> resultado) {
		if (usado.size() == conjunto.size()) {
			if (solucion(resultado)) {
				return true;
			}
		} else {
			for (Integer numero : conjunto) {
				if (!usado.contains(numero)) {
					usado.add(numero);
					parcial.add(numero);
					if (parcial.size() == N) {
						if (suma(parcial) == 0) {
							resultado.add(new ArrayList<Integer>(parcial));
							boolean retorno = _getSubconjuntos(conjunto, usado, new ArrayList<Integer>(), resultado);
							if (retorno) {
								return true;
							}
						}
					} else {
						boolean retorno = _getSubconjuntos(conjunto, usado, parcial, resultado);
						if (retorno) {
							return true;
						}
					}
					usado.remove(usado.size() - 1);
					parcial.remove(parcial.size() - 1);
				}
			}
		}
		return false;
	}

	private boolean solucion(List<List<Integer>> resultado) {
		for (List<Integer> parcial : resultado) {
			if (suma(parcial) != 0) {
				return false;
			}
		}
		return true;
	}

	private int suma(List<Integer> parcial) {
		int total = 0;
		for (int n : parcial) {
			total += n;
		}
		return total;
	}

}
