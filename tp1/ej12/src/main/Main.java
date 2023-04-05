package main;

import util.UtilRecursivo;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 12.
	Implemente un algoritmo recursivo que convierta un número en notación decimal a su
	equivalente en notación binaria.
	Recordatorio, por ejemplo convertir el 26 a binario:
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
		int element = 26;
		System.out.println(UtilRecursivo.toBinario(element));
		
		
	}

}
