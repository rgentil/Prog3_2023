package main;

import java.util.ArrayList;
import java.util.List;

import backtracking.Backtracking;

/**
 * Ejercicio 3. Suma de subconjuntos. Dados n números positivos distintos, se
 * desea encontrar todas las combinaciones de esos números tal que la suma sea
 * igual a M.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(2);
		numeros.add(4);
		numeros.add(5);
		numeros.add(1);
		numeros.add(3);

		Backtracking backtracking = new Backtracking(numeros, 6);

		List<List<Integer>> resultado = backtracking.subconjuntos();
		for (List<Integer> subset : resultado) {
			System.out.println(subset);
		}

	}

}
