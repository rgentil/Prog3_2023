package main;

import java.util.ArrayList;
import java.util.List;

import backtracking.Backtracking;

/**
 * Ejercicio 4. Partición de conjunto. Dado un conjunto de n enteros se desea
 * encontrar, si existe, una partición en dos subconjuntos disjuntos, tal que la
 * suma de sus elementos sea la misma.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(1);
		numeros.add(2);
		numeros.add(5);
		numeros.add(1);

		Backtracking backtracking = new Backtracking(numeros);

		List<List<Integer>> resultado = backtracking.getSubConjuntosDisjuntosIguales();
		if (resultado.isEmpty()) {
			System.out.println("No se encontró una partición equilibrada.");
		} else {
			System.out.println("Partición equilibrada encontrada:");
			for (List<Integer> subset : resultado) {
				System.out.println(subset);
			}
		}

	}

}
