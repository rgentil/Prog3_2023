package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

	private List<Integer> numeros;
	private List<List<Integer>> resultados;
	private int N;

	public Backtracking(List<Integer> numeros) {
		super();
		this.numeros = numeros;
		this.N = numeros.size();
	}

	public List<List<Integer>> back() {
		resultados = new ArrayList<List<Integer>>();
		List<Integer> parcial = new ArrayList<Integer>();
		_back(numeros, parcial);
		return resultados;
	}

	private void _back(List<Integer> numeros, List<Integer> parcial) {
		if (parcial.size() == N) {
			resultados.add(new ArrayList<Integer>(parcial));
		} else {
			for (Integer numero : numeros) {
				if (!parcial.contains(numero)) {
					parcial.add(numero);
					_back(numeros, parcial);
					parcial.remove(parcial.size() - 1);
				}
			}
		}
	}

	public List<List<Integer>> back2() {
		resultados = new ArrayList<List<Integer>>();
		List<Integer> parcial = new ArrayList<Integer>();
		_back2(numeros, parcial);
		return resultados;
	}

	private void _back2(List<Integer> numeros, List<Integer> parcial) {
		if (parcial.size() == N) {
			resultados.add(new ArrayList<Integer>(parcial));
		} else {
			for (Integer numero : numeros) {
				// Sin controlar que lo tenga en mi solucion me genera con valores repetidos
				// tambien. Esto puede servir para el ejercicio de las palabras con prefijos.
				// if (!parcial.contains(numero)) {
				parcial.add(numero);
				_back2(numeros, parcial);
				parcial.remove(parcial.size() - 1);
				// }
			}
		}
	}

}
