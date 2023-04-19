package orden;

public class Orden {
	
	/*
	 * El método de ordenación por selección consiste en repetir los siguientes
	 * pasos: Se busca el elemento más pequeño del array y se coloca en la primera
	 * posición. Entre los restantes, se busca el elemento más pequeño y se coloca
	 * en la segunda posición. Entre los restantes se busca el elemento más pequeño
	 * y se coloca en la tercera posición.
	 */

	/*
	 * El método de ordenación por selección consiste en repetir los siguientes
	 * pasos: Se busca el elemento más pequeño del array y se coloca en la primera
	 * posición. Entre los restantes, se busca el elemento más pequeño y se coloca
	 * en la segunda posición. Entre los restantes se busca el elemento más pequeño
	 * y se coloca en la tercera posición.
	 */

	// Tiempo de ejecución O(n2)
	
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
