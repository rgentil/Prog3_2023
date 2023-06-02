package main;

import java.util.ArrayList;
import java.util.List;

import backtracking.Backtracking;

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
public class Main {

	public static void main(String[] args) {
		List<Integer> conjunto = new ArrayList<Integer>();
		conjunto.add(-7);
		conjunto.add(-3);
		conjunto.add(-2);
		conjunto.add(-1);
		conjunto.add(5);
		conjunto.add(8);

		int N = 3;

		System.out.println("Tamanio de sub conjuntos: " + N + "\nConjunto inicial: ");
		for (int i : conjunto) {
			System.out.print(" | " + i + " | ");
		}

		Backtracking backtracking = new Backtracking(conjunto, N);
		List<List<Integer>> resultado = backtracking.getSubconjuntos();

		System.out.println("\n\n Resultado");
		for (List<Integer> subConjunto : resultado) {
			System.out.println("");
			for (int i : subConjunto) {
				System.out.print(" | " + i + " | ");
			}
		}
	}

}
