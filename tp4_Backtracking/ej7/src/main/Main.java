package main;

import java.util.List;

import backtracking.Backtracking;

/**
 * Ejercicio 7. Tablero mágico. Dado un tablero de tamaño n x n, construir un
 * algoritmo que ubique (si es posible) n*n números naturales diferentes, entre
 * 1 y un cierto k (con k>n*n), de manera tal que la suma de las columnas y de
 * las filas sea igual a S.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		int N = 3;
		int K = 10;
		int S = 15;

		Backtracking backtracking = new Backtracking(N, K, S);

		Integer[][] tablero = backtracking.ubicar();
		System.out.println("Tablero [" + N + "][" + N + "] : ");
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.print("   " + tablero[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("--------Todos los tableros generados-------------------\n");

		Backtracking backtracking2 = new Backtracking(N, K, S);
		List<Integer[][]> tableros = backtracking2.getTodosLasUbicaciones();
		System.out.println("Tablero [" + N + "][" + N + "] : ");

		int cont = 1;
		for (Integer[][] t : tableros) {
			System.out.println("\n Tablero " + cont + ": ");
			for (int i = 0; i < N; i++) {
				System.out.println();
				for (int j = 0; j < N; j++) {
					System.out.print("   " + t[i][j] + " ");
				}
				System.out.println();
			}
			cont++;
		}

	}

}
