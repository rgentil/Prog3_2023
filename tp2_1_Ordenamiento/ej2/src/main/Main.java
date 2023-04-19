package main;

import java.util.Arrays;

import orden.MergeSort;
import orden.QuickSort;
/*
Ejercicio 2.
Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
1. ¿Cuál es su complejidad en el peor caso?
2. ¿Cuál es su complejidad promedio?
*/	
public class Main {

	public static void main(String[] args) {
		//Merge Sort
		System.out.println("Merge Sort");
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
		System.out.println(Arrays.toString(arr));
		MergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        
        System.out.println("-------------------------------------------------------------------------------------------");
        
        //QuickSort
        System.out.println("Quick Sort");
        int[] arr1 = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println(Arrays.toString(arr1));
		QuickSort.quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
	}

}
