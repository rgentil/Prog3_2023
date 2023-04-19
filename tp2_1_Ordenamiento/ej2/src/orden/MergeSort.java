package orden;

/*
Ejercicio 2.
Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
1. ¿Cuál es su complejidad en el peor caso?
2. ¿Cuál es su complejidad promedio?
*/	
public class MergeSort {
	
	/*
	 * Funcionamiento del método MergeSort es el siguiente: - Si la longitud del
	 * array es menor o igual a 1 entonces ya está ordenado. - El array a ordenar se
	 * divide en dos mitades de tamaño similar. - Cada mitad se ordena de forma
	 * recursiva aplicando el método MergeSort. - A continuación las dos mitades ya
	 * ordenadas se mezclan formando una secuencia ordenada.
	 * 
	 * Este programa ordena un arreglo de enteros utilizando Merge Sort. 
	 * La función mergeSort toma el arreglo a ordenar, el índice izquierdo y derecho del subarreglo a ordenar. 
	 * La función divide el arreglo en mitades recursivamente y luego mezcla las dos mitades utilizando la función merge.
	   La función merge mezcla dos subarreglos ya ordenados. 
	   Utiliza un arreglo temporal para almacenar los elementos ordenados de ambos subarreglos y 
	   luego los copia de vuelta al arreglo original en orden.
	   
	   La complejidad temporal de Merge Sort en el peor caso y en el caso promedio es O(n log n).
	   
	 */
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr,left,mid,right);
		}
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		//Arreglo temporal para ir guardando los valores originales para devolverlos ordenados
		int[] temp = new int[right - left + 1];
		//Indice para moverne entre los dos arreglos, i y j en el original k en el temporal
		int i = left ,j = mid + 1 ,k = 0;
		//Ordeno hasta que se llegue al limite de left hasta mid y de mid + 1 hasta right
		while ( i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		//Si quedan valores en la parte de i y el medio los copio al temporal
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		
		//Si quedan valores en la parte de j y el final los copio al temporal
		while(j <= right) {
			temp[k++] = arr[j++];
		}
		
		//Finalmente copio los valores del temporal al arreglo orginal ordenados
		for (int k2 = 0; k2 < temp.length; k2++) {
			arr[left + k2] = temp[k2];
		}
	}
	
}
