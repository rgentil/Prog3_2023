package tudai.prog3.main;

import tudai.prog3.collections.Tree;

/*
 * Ejercicio 1.
Implemente la estructura de Árbol Binario para búsquedas.
Métodos:
● Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List
getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?
 */
public class Main_ej_1_2_3 {

	public static void main(String[] args) {

		Tree tree = new Tree();

		Integer[] arr = { 6, 2, 1, 4, 10, 8, 11, 7, 9 };
		for (Integer value : arr) {
			tree.insert(value);
		}

		tree.print();

		System.out.println("Altura máxima " + tree.getHeight());
		System.out.println("Rama más larga " + tree.getLongestBranch().toString());
		System.out.println("Frontera " + tree.getFrontier().toString());
		System.out.println("Máximo elemento " + tree.getMaxElem());

		for (int i = 0; i < tree.getHeight(); i++) {
			System.out.println("Elemento en el nivel " + i + ": " + tree.getElemAtLevel(i));
		}

		/*
		 * Ejercicio 2 Dado un árbol binario de búsquedas que almacena números enteros,
		 * implementar un algoritmo que retorne la suma de todos los nodos internos del
		 * árbol.
		 */
		System.out.println("Suma total de los elementos: " + tree.sum());

		/*
		 * Ejercicio 3 Dado un árbol binario de búsqueda que almacena números enteros y
		 * un valor de entrada K, implementar un algoritmo que permita obtener un
		 * listado con los valores de todas las hojas cuyo valor supere K. Por ejemplo,
		 * para el árbol de la derecha, con un valor K = 8, el resultado debería ser [9,
		 * 11].
		 */
		System.out.println("Listado con los valores de todas las hojas cuyo valor supere K: " + tree.getLeavesGreaterThan(2));
		
		tree.delete(6);
		tree.print();

	}

}
