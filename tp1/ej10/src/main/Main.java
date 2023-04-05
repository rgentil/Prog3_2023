package main;

import util.UtilRecursivo;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 10.
	Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
	1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
	2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
	3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
	*/
	
	public static void main(String[] args) {
		
		//System.out.println(UtilRecursivo.isPalindroma("arooa"));
		
		Number[] arr = {2,3,4,5,1};
		Number[] arr1 = {1,3,4,5,9};
		System.out.println(UtilRecursivo.isOrdered(arr));
		System.out.println(UtilRecursivo.isOrdered(arr1));
	}

}
