package main;

import util.UtilRecursivo;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 13.
	Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
	Fibonacci.
	Por ej. los 6 primeros términos son: 0 1 1 2 3 5
	*/
	
	public static void main(String[] args) {
		
		//System.out.println(UtilRecursivo.isPalindroma("arooa"));
		
		/*Number[] arr = {2,3,4,5,1};
		Number[] arr1 = {1,3,4,5,9};
		System.out.println(UtilRecursivo.isOrdered(arr));
		System.out.println(UtilRecursivo.isOrdered(arr1));*/
		
		/*Number[] arr = {2,3,7,9,90,99};
		int element = 99;
		System.out.println(UtilRecursivo.findElement(arr, element));*/
		
		/*int element = 26;
		System.out.println(UtilRecursivo.toBinario(element));*/
		
		int N_iteraciones = 6;
		System.out.println(UtilRecursivo.fibonacci(N_iteraciones));
		
		for (int i = 0; i < N_iteraciones; i++) {
            System.out.print(UtilRecursivo.fibonacci(i) + " ");
        }
		
	}

}
