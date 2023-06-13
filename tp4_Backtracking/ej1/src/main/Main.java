package main;

import backtracking.Backtracking;
import collections.Grafo;
import collections.GrafoDirigido;

/**
 * Ejercicio 1. Se tiene un conjunto de salas comunicadas entre s� a trav�s de
 * puertas que se abren solamente en un sentido. Una de las salas se denomina
 * entrada y la otra salida. Construir un algoritmo que permita ir desde la
 * entrada a la salida atravesando la m�xima cantidad de salas. Idea: podr�a
 * representar el problema mediante un grafo dirigido, donde cada nodo es una
 * habitaci�n, y cada puerta es un arco dirigido hacia otra habitaci�n.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		Grafo<Integer> salas = new GrafoDirigido<Integer>();
		salas.agregarArco(1, 2, null);
		salas.agregarArco(1, 3, null);
		salas.agregarArco(1, 4, null);
		salas.agregarArco(2, 3, null);
		salas.agregarArco(2, 5, null);
		salas.agregarArco(2, 7, null);
		//salas.agregarArco(3, 4, null);
		salas.agregarArco(4, 5, null);
		salas.agregarArco(4, 6, null);
		salas.agregarArco(5, 6, null);
		salas.agregarArco(6, 7, null);

		salas.imprimir();

		Backtracking backtracking = new Backtracking(salas);
		System.out.println(backtracking.getSalida(1, 7).toString());

	}

}
