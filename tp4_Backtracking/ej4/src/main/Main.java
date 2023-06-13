package main;

import java.util.ArrayList;
import java.util.List;

import backtracking.Backtracking;

/**
 * Ejercicio 4. Partici�n de conjunto. Dado un conjunto de n enteros se desea
 * encontrar, si existe, una partici�n en dos subconjuntos disjuntos, tal que la
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

		System.out.println("Conjunto de numeros para particionar: " + numeros.toString());

		Backtracking backtracking = new Backtracking(numeros);

		List<List<Integer>> resultado = backtracking.getSubConjuntosDisjuntosIguales();
		if (resultado.isEmpty()) {
			System.out.println("No se encontr� una partici�n equilibrada.");
		} else {
			System.out.println("Partici�n equilibrada encontrada:");
			for (List<Integer> subset : resultado) {
				System.out.println(subset);
			}
		}

	}

}
