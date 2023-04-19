package orden;
/*
Ejercicio 1.
Implemente un algoritmo de ordenamiento por selecci�n en un arreglo.
Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
1. �Qu� complejidad O tienen estos algoritmos?
Ambos son m�todos iterativos, no son recursivos. Ambos son O(n2) al tener que recorrer dos veces la totalidad de los elementos
*/	
public class BubleSelectionSort {
	
	/* selecci�n
	 * El m�todo de ordenaci�n por selecci�n consiste en repetir los siguientes
	 * pasos: Se busca el elemento m�s peque�o del array y se coloca en la primera
	 * posici�n. Entre los restantes, se busca el elemento m�s peque�o y se coloca
	 * en la segunda posici�n. Entre los restantes se busca el elemento m�s peque�o
	 * y se coloca en la tercera posici�n.
	 */

	// Tiempo de ejecuci�n O(n2)
	public static int findSmallest(int[] arr, int init_pos) {
		int smallest = 99;
		int smallest_index = -1;
		for (int i = init_pos; i < arr.length; i++) {
			if (arr[i] < smallest) {
				smallest = arr[i];
				smallest_index = i;
			} 
		}
		return smallest_index;
	} 
	
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int smallest_index = findSmallest(arr,i);
			if (arr[i] > arr[smallest_index]) {
				int aux = arr[i];
				arr[i] = arr[smallest_index];
				arr[smallest_index] = aux;
			}			
		}
	}
	
	/* burbujeo
	 * Consiste en comparar pares de elementos adyacentes en un array y si est�n
	 * desordenados intercambiarlos hasta que est�n todos ordenados. El elemento
	 * mayor sube como una burbuja hacia la posici�n m�s alta.
	 */
	// Tiempo de ejecuci�n O(n2)
	
	public static void burbugeo(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int aux = arr[i];
					arr[i] = arr[j];
					arr[j] = aux;
				} 
			}
		}
	} 
	
}
