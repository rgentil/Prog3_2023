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

	private List<Integer> numeros;
	private Integer M;

	public Backtracking(List<Integer> numeros, Integer M) {
		this.numeros = numeros;
		this.M = M;
	}

	public List<List<Integer>> subconjuntos() {
		List<Integer> parcial = new ArrayList<Integer>();
		List<List<Integer>> solucion = new ArrayList<List<Integer>>();
		_subconjuntos(numeros, parcial, solucion, M, 0);
		return solucion;
	}

	private void _subconjuntos(List<Integer> conjunto_numeros, List<Integer> parcial, List<List<Integer>> solucion,
			Integer remanente, int inicio) {
		if (remanente == 0) {
			solucion.add(new ArrayList<Integer>(parcial));
		} else {
			for (int i = inicio; i < conjunto_numeros.size(); i++) {
				Integer num = conjunto_numeros.get(i);
				if (num <= remanente && !parcial.contains(num)) {
					parcial.add(num);
					remanente -= num;
					inicio += 1;
					_subconjuntos(conjunto_numeros, parcial, solucion, remanente, inicio);
					parcial.remove(num);
					remanente += num;
					inicio -= 1;
				}
			}
		}

	}

}
