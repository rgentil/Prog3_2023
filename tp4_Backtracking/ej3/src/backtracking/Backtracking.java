package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 3. Suma de subconjuntos. Dados n números positivos distintos, se
 * desea encontrar todas las combinaciones de esos números tal que la suma sea
 * igual a M.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private List<Integer> conjunto_numeros;
	private List<Integer> sub_conjunto;
	private List<List<Integer>> sub_conjuntos;
	private int M;

	public Backtracking(List<Integer> c, int M) {
		this.conjunto_numeros = c;
		this.M = M;
		this.sub_conjuntos = new ArrayList<List<Integer>>();
		this.sub_conjunto = new ArrayList<Integer>();
	}

	public List<List<Integer>> getSubConjuntos() {
		_getSubConjuntos(conjunto_numeros, sub_conjunto, sub_conjuntos, M, 0);
		return sub_conjuntos;
	}

	private void _getSubConjuntos(List<Integer> conjunto_numeros, List<Integer> sub_conjunto,
			List<List<Integer>> sub_conjuntos, int M, int suma) {
		if (conjunto_numeros.isEmpty()) {
			if (suma == M) {
				sub_conjuntos.add(new ArrayList<Integer>(sub_conjunto));
			}
		} else {
			// Estado en el que el numero del conjunto no va en el sub conjunto resultado
			Integer numero = conjunto_numeros.remove(0);
			_getSubConjuntos(conjunto_numeros, sub_conjunto, sub_conjuntos, M, suma);
			conjunto_numeros.add(0, numero);

			// Estado en el que el numero del conjunto si va en el sub conjunto resultado
			numero = conjunto_numeros.remove(0);
			suma += numero;
			if (suma <= M) {
				sub_conjunto.add(numero);
				_getSubConjuntos(conjunto_numeros, sub_conjunto, sub_conjuntos, M, suma);
				sub_conjunto.remove(numero);
			}
			conjunto_numeros.add(0, numero);
			suma -= numero;
			
		}

	}

}
