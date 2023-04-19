package orden;

/*
Ejercicio 2.
Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
1. ¿Cuál es su complejidad en el peor caso?
2. ¿Cuál es su complejidad promedio?
*/	
public class QuickSort {
	/*
	Quicksort
		
		Es el algoritmo de ordenación más rápido.
		Se basa en la técnica divide y vencerás, que consiste en ir subdividiendo el array en arrays más pequeños, y ordenar éstos. 
		Para hacer esta división, se toma un valor del array como pivote, y se mueven todos los elementos menores que este pivote a su izquierda,
		y los mayores a su derecha. 
		A continuación se aplica el mismo método a cada una de las dos partes en las que queda dividido el array.
		Después de elegir el pivote se realizan dos búsquedas:
			Una de izquierda a derecha, buscando un elemento mayor que el pivote
			Otra de derecha a izquierda, buscando un elemento menor que el pivote.
			Cuando se han encontrado los dos elementos anteriores, se intercambian, y se sigue realizando la búsqueda hasta que las dos búsquedas 
			se encuentran.
		Suponiendo que tomamos como pivote el primer elemento, el método Quicksort que implementa este algoritmo de ordenación para ordenar 
		un array de enteros se presenta a continuación. 
		
		Los parámetros izq y der son el primer y último elemento del array a tratar en cada momento.
		El método ordena un array A de enteros desde la posición izq hasta la posición der. 
		
		En la primera llamada recibirá los valores izq = 0, der = ELEMENTOS-1.
		
		En el peor caso, cuando el pivote es el elemento menor del array el tiempo de ejecución del método Quicksort es O(n2).
		En general el tiempo medio de ejecución del Quicksort es O(n log n).
		
		No requiere memoria adicional
		
	*/
	
	public static void quickSort(int[] arr, int start, int end) {
		//Seleccionamos un pivote. Tomamos el de la mitad
		int pivoteIndex = (start + end) / 2; 
		int pivote = arr[pivoteIndex];
		
		//Dividimos el arreglo a la mitad, i y j para recorrer de izq a derecha y de derecha a izquierda.
		/*Una vez que tenemos el pivote, debemos dividir el arreglo en dos partes: una con elementos menores al pivote y 
		otra con elementos mayores al pivote. 
		Para hacer esto, utilizaremos dos índices: i y j. i apuntará al primer elemento del arreglo y j
	 	apuntará al último elemento del arreglo. Luego, moveremos i hacia la derecha y j hacia la izquierda hasta que 
		arr[i] sea mayor o igual al pivote y arr[j] sea menor o igual al pivote. Cuando esto suceda, intercambiaremos 
		los valores de arr[i] y arr[j]. Continuaremos haciendo esto hasta que i sea mayor o igual a j. Cuando esto suceda, 
		el arreglo estará dividido en dos partes, como se muestra a continuación:
		*/
		int i = start;
		int j = end;
		
		while (i <= j) {
			
			while (arr[i] < pivote) {
				i++;
			}
			
			while (arr[j] > pivote) {
				j--;
			}
			
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		/*
		Una vez que el arreglo está dividido en dos partes, debemos ordenar cada parte por separado. 
		Para hacer esto, simplemente llamamos al método quickSort recursivamente, 
		una vez para la parte del arreglo que contiene elementos menores al pivote y 
		otra vez para la parte del arreglo que contiene elementos mayores al pivote. 
		La siguiente línea de código muestra cómo llamar al método recursivamente:
		 */
		if (start < j) {
			quickSort(arr, start, j);
		}
		
		if (i < end) {
			quickSort(arr, i, end);
		}
	}
	

	
}
