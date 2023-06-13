package main;

import java.util.ArrayList;
import java.util.List;

import backtracking.Backtracking;

/**
 * Ejercicio 3. Suma de subconjuntos. Dados n n�meros positivos distintos, se
 * desea encontrar todas las combinaciones de esos n�meros tal que la suma sea
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
		System.out.print("Numeros : " + numeros.toString() + " subconjuntos que sumen 6 \n");
		Backtracking backtracking = new Backtracking(numeros, 6);

		List<List<Integer>> resultado = backtracking.getSubConjuntos();
		for (List<Integer> subset : resultado) {
			System.out.println(subset);
		}
		
		System.out.print("\n Numeros : " + numeros.toString() + " subconjuntos que sumen 6 \n");
		Backtracking backtracking2 = new Backtracking(numeros, 6);

		List<List<Integer>> resultado2 = backtracking2.getSubConjuntos2();
		for (List<Integer> subset : resultado2) {
			System.out.println(subset);
		}

	}

}
