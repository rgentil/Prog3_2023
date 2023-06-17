package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 3. Suma de subconjuntos. Dados n n�meros positivos distintos, se
 * desea encontrar todas las combinaciones de esos n�meros tal que la suma sea
 * igual a M.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private List<Integer> conjunto_numeros;
	private List<Integer> sub_conjunto;
	private List<List<Integer>> sub_conjuntos;
	private List<Integer> visitados;
	private int M;

	public Backtracking(List<Integer> c, int M) {
		this.conjunto_numeros = c;
		this.M = M;
		this.sub_conjuntos = new ArrayList<List<Integer>>();
		this.sub_conjunto = new ArrayList<Integer>();
		this.visitados = new ArrayList<Integer>();
	}

	public List<List<Integer>> getSubConjuntos() {
		// Solución sacando el número del conjunto, lo pongo o no lo pongo
		_getSubConjuntos(conjunto_numeros, sub_conjunto, 0);
		return sub_conjuntos;
	}

	private void _getSubConjuntos(List<Integer> conjunto_numeros, List<Integer> sub_conjunto, int suma) {
		if (conjunto_numeros.isEmpty()) {
			if (suma == M) {
				sub_conjuntos.add(new ArrayList<Integer>(sub_conjunto));
			}
		} else {
			// Estado en el que el numero del conjunto no va en el sub conjunto resultado
			Integer numero = conjunto_numeros.remove(0);
			_getSubConjuntos(conjunto_numeros, sub_conjunto, suma);
			conjunto_numeros.add(0, numero);

			// Estado en el que el numero del conjunto si va en el sub conjunto resultado
			numero = conjunto_numeros.remove(0);
			suma += numero;
			if (suma <= M) {
				sub_conjunto.add(numero);
				_getSubConjuntos(conjunto_numeros, sub_conjunto, suma);
				sub_conjunto.remove(numero);
			}
			conjunto_numeros.add(0, numero);
			suma -= numero;
		}
	}

	public List<List<Integer>> getSubConjuntos2() {
		// Solucion marcando el numero como visitado si lo pongo o no.
		this.visitados = new ArrayList<Integer>();
		_getSubConjuntos2(conjunto_numeros, sub_conjunto, visitados, 0);
		return sub_conjuntos;
	}

	private void _getSubConjuntos2(List<Integer> conjunto_numeros, List<Integer> sub_conjunto, List<Integer> visitados,
			int suma) {
		if (conjunto_numeros.size() == visitados.size()) {
			if (suma == M) {
				List<Integer> aux = new ArrayList<Integer>(sub_conjunto);
				if (!sub_conjuntos.contains(aux)) {
					sub_conjuntos.add(aux);
				}
			}
		} else {
			for (Integer numero : conjunto_numeros) {
				if (!visitados.contains(numero)) {
					visitados.add(numero);
					_getSubConjuntos2(conjunto_numeros, sub_conjunto, visitados, suma);
					suma += numero.intValue();
					if (suma <= M) {
						sub_conjunto.add(numero);
						_getSubConjuntos2(conjunto_numeros, sub_conjunto, visitados, suma);
						sub_conjunto.remove(sub_conjunto.size() - 1);
					}
					suma -= numero.intValue();
					visitados.remove(visitados.size() - 1);
				}
			}
		}
	}

}
