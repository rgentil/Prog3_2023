package main;

import backtracking.Backtracking;

/**
 * Ejercicio 8. Colocar un entero positivo (menor que un cierto valor entero k
 * dado) en cada casilla de una pirámide de base B (valor entero dado) de modo
 * que cada número sea igual a la suma de las casillas sobre las que está
 * apoyado. Los números de todas las casillas deben ser diferentes.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		int K = 15;
		int base = 5;
		
		Backtracking backtracking = new Backtracking(K, base);
		
		backtracking.generarPiramide();

	}

}
