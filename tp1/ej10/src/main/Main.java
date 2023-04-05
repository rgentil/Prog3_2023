package main;

import util.UtilRecursivo;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 10.
	Implemente un algoritmo recursivo que determine si un arreglo de tama�o N est� ordenado.
	1. �Qu� complejidad O tiene? (La complejidad en el peor caso)
	2. �Trae alg�n problema hacerlo recursivo? �Cu�l?
	3. �Qu� cambiar�a si la estructura fuera una lista en lugar de un arreglo?
	*/
	
	public static void main(String[] args) {
		
		//System.out.println(UtilRecursivo.isPalindroma("arooa"));
		
		Number[] arr = {2,3,4,5,1};
		Number[] arr1 = {1,3,4,5,9};
		System.out.println(UtilRecursivo.isOrdered(arr));
		System.out.println(UtilRecursivo.isOrdered(arr1));
	}

}
