package main;

import java.util.Arrays;

import orden.Orden;
/*
Ejercicio 1.
Implemente un algoritmo de ordenamiento por selección en un arreglo.
Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
1. ¿Qué complejidad O tienen estos algoritmos?
*/	
public class Main {

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,3,11};
		
		System.out.println("Arreglo original: " + Arrays.toString(arr));
		/*for (int numero:arr) {
			System.out.print(" - " + numero);
		}*/

		System.out.println(" \n El menor valor está en la posición: " + Orden.findSmallest(arr,0));
		Orden.selectionSort(arr);
		
		System.out.println(" \n El arreglo ordenado por selección " + Arrays.toString(arr) );
		
		int[] arr2 = {41,53,62,75,23,18};
		System.out.println(" \n -----------------------------------------------------------------------------");
		System.out.println(" \n Arreglo original " + Arrays.toString(arr2));

		Orden.burbugeo(arr2);
		
		System.out.println(" \n El arreglo ordenado por burbugeo "  + Arrays.toString(arr2));

	
	}

}
