package orden;

public class Orden {
	
	/*
	 * El m�todo de ordenaci�n por selecci�n consiste en repetir los siguientes
	 * pasos: Se busca el elemento m�s peque�o del array y se coloca en la primera
	 * posici�n. Entre los restantes, se busca el elemento m�s peque�o y se coloca
	 * en la segunda posici�n. Entre los restantes se busca el elemento m�s peque�o
	 * y se coloca en la tercera posici�n.
	 */

	/*
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

}
