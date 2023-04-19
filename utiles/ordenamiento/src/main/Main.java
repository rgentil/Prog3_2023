package main;

import orden.Orden;

public class Main {

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,3,11};
		
		System.out.println("Arreglo original");
		for (int numero:arr) {
			System.out.print(" - " + numero);
		}

		System.out.println(" \n El menor valor está en la posición: " + Orden.findSmallest(arr,0));
		Orden.selectionSort(arr);
		
		System.out.println(" \n El arreglo ordenado");
		for (int numero:arr) {
			System.out.print(" - " + numero);
		}
	
	}

}
