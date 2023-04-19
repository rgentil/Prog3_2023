package orden;

/*
Ejercicio 2.
Implemente un algoritmo de ordenamiento mergesort para un arreglo de tama�o N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tama�o N.
1. �Cu�l es su complejidad en el peor caso?
2. �Cu�l es su complejidad promedio?
*/	
public class QuickSort {
	/*
	Quicksort
		
		Es el algoritmo de ordenaci�n m�s r�pido.
		Se basa en la t�cnica divide y vencer�s, que consiste en ir subdividiendo el array en arrays m�s peque�os, y ordenar �stos. 
		Para hacer esta divisi�n, se toma un valor del array como pivote, y se mueven todos los elementos menores que este pivote a su izquierda,
		y los mayores a su derecha. 
		A continuaci�n se aplica el mismo m�todo a cada una de las dos partes en las que queda dividido el array.
		Despu�s de elegir el pivote se realizan dos b�squedas:
			Una de izquierda a derecha, buscando un elemento mayor que el pivote
			Otra de derecha a izquierda, buscando un elemento menor que el pivote.
			Cuando se han encontrado los dos elementos anteriores, se intercambian, y se sigue realizando la b�squeda hasta que las dos b�squedas 
			se encuentran.
		Suponiendo que tomamos como pivote el primer elemento, el m�todo Quicksort que implementa este algoritmo de ordenaci�n para ordenar 
		un array de enteros se presenta a continuaci�n. 
		
		Los par�metros izq y der son el primer y �ltimo elemento del array a tratar en cada momento.
		El m�todo ordena un array A de enteros desde la posici�n izq hasta la posici�n der. 
		
		En la primera llamada recibir� los valores izq = 0, der = ELEMENTOS-1.
		
		En el peor caso, cuando el pivote es el elemento menor del array el tiempo de ejecuci�n del m�todo Quicksort es O(n2).
		En general el tiempo medio de ejecuci�n del Quicksort es O(n log n).
		
		No requiere memoria adicional
		
	*/
	
	public static void quickSort(int[] arr, int start, int end) {
		//Seleccionamos un pivote. Tomamos el de la mitad
		int pivoteIndex = (start + end) / 2; 
		int pivote = arr[pivoteIndex];
		
		//Dividimos el arreglo a la mitad, i y j para recorrer de izq a derecha y de derecha a izquierda.
		/*Una vez que tenemos el pivote, debemos dividir el arreglo en dos partes: una con elementos menores al pivote y 
		otra con elementos mayores al pivote. 
		Para hacer esto, utilizaremos dos �ndices: i y j. i apuntar� al primer elemento del arreglo y j
	 	apuntar� al �ltimo elemento del arreglo. Luego, moveremos i hacia la derecha y j hacia la izquierda hasta que 
		arr[i] sea mayor o igual al pivote y arr[j] sea menor o igual al pivote. Cuando esto suceda, intercambiaremos 
		los valores de arr[i] y arr[j]. Continuaremos haciendo esto hasta que i sea mayor o igual a j. Cuando esto suceda, 
		el arreglo estar� dividido en dos partes, como se muestra a continuaci�n:
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
		Una vez que el arreglo est� dividido en dos partes, debemos ordenar cada parte por separado. 
		Para hacer esto, simplemente llamamos al m�todo quickSort recursivamente, 
		una vez para la parte del arreglo que contiene elementos menores al pivote y 
		otra vez para la parte del arreglo que contiene elementos mayores al pivote. 
		La siguiente l�nea de c�digo muestra c�mo llamar al m�todo recursivamente:
		 */
		if (start < j) {
			quickSort(arr, start, j);
		}
		
		if (i < end) {
			quickSort(arr, i, end);
		}
	}
	

	
}
