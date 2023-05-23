package main;

import java.util.List;

import Coleccion.Laberinto;
import Coleccion.Nodo;
import backtracking.Backtracking;

/**
 * Ejercicio 2. Dado un laberinto consistente en una matriz cuadrada que tiene
 * en cada posición un valor natural y cuatro valores booleanos, indicando estos
 * últimos si desde esa casilla se puede ir al norte, este, sur y oeste,
 * encontrar un camino de longitud mínima entre dos casillas dadas, siendo la
 * longitud de un camino la suma de los valores naturales de las casillas por
 * las que pasa. Idea: podría representarse el laberinto como una matriz, de
 * objetos, donde cada objeto tiene el valor natural, y cuatro booleanos, uno
 * para cada dirección a la que se permite ir desde allí.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {

		// Nodo(nombre, fila, columna, valor, norte, sur, este, oeste )
		Laberinto laberinto = new Laberinto(3);

		Nodo n00 = new Nodo("N00", 0, 0, 1, false, true, true, false);
		laberinto.inertarNodo(n00);

		Nodo n01 = new Nodo("N01", 0, 1, 6, false, true, true, true);
		laberinto.inertarNodo(n01);

		Nodo n02 = new Nodo("N02", 0, 2, 2, false, true, false, true);
		laberinto.inertarNodo(n02);

		Nodo n10 = new Nodo("N10", 1, 0, 4, true, true, true, false);
		laberinto.inertarNodo(n10);

		Nodo n11 = new Nodo("N11", 1, 1, 1, true, true, true, true);
		laberinto.inertarNodo(n11);

		Nodo n12 = new Nodo("N12", 1, 2, 3, false, true, false, true);
		laberinto.inertarNodo(n12);

		Nodo n20 = new Nodo("N20", 2, 0, 5, true, false, true, false);
		laberinto.inertarNodo(n20);

		Nodo n21 = new Nodo("N21", 2, 1, 2, true, false, true, true);
		laberinto.inertarNodo(n21);

		Nodo n22 = new Nodo("N22", 2, 2, 1, true, false, false, true);
		laberinto.inertarNodo(n22);

		laberinto.imprimir();

		Backtracking backtracking = new Backtracking(laberinto);
		List<Nodo> resultado = backtracking.getCaminoMinimo(0, 0, 2, 2);
		System.out.println("\nCamino mas corto entre [0,0] a [2,2]");
		for (Nodo nodo : resultado) {
			System.out.print(nodo.getNombre() + "-" + nodo.getValor() + " | ");
		}

		System.out.println("\n");
		
		Laberinto laberinto2 = new Laberinto(2);

		// Nodo(nombre, fila, columna, valor, norte, sur, este, oeste )

		Nodo nodo00 = new Nodo("N00", 0, 0, 1, false, true, true, false);
		laberinto2.inertarNodo(nodo00);

		Nodo nodo01 = new Nodo("N01", 0, 1, 6, false, true, false, true);
		laberinto2.inertarNodo(nodo01);

		Nodo nodo10 = new Nodo("N10", 1, 0, 2, true, false, true, false);
		laberinto2.inertarNodo(nodo10);

		Nodo nodo11 = new Nodo("N11", 1, 1, 4, true, false, false, true);
		laberinto2.inertarNodo(nodo11);

		laberinto2.imprimir();

		Backtracking backtracking2 = new Backtracking(laberinto2);
		List<Nodo> resultado2 = backtracking2.getCaminoMinimo(0, 0, 1, 1);
		System.out.println("\nCamino mas corto entre [0,0] a [1,1]");
		for (Nodo nodo : resultado2) {
			System.out.print(nodo.getNombre() + "-" + nodo.getValor() + " | ");
		}

	}

}
