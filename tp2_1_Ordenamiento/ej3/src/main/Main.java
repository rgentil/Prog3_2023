package main;

import java.util.Arrays;
import java.util.Random;

import orden.BubleSelectionSort;
import orden.MergeSort;
import orden.QuickSort;
import util.Timer;
/*
Ejercicio 3.
Implemente una función que cree un arreglo de tamaño N con números aleatorios. 
Corra los algoritmos de los ejercicios 3 y 4, 10000 veces consecutivas cada uno, y compruebe el tiempo
de ejecución. Haga lo mismo con el método Arrays.sort(...) de Java, y compare los tiempos
obtenidos. Investigue cómo está implementado el Array.sort()
*/	
public class Main {

	public static void main(String[] args) {
		Timer reloj = new Timer();
		reloj.start();
		double tiempo = reloj.stop();
		System.out.println("Prueba time: " + tiempo);        
        
		int N_iteraciones = 1000;
		
		reloj.start();
		int N = 10;
		int[] arreglo = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arreglo[i] = random.nextInt(100);
        }
        tiempo = reloj.stop();
		System.out.println("Tiempo en crear el arreglo: " + tiempo); 
        System.out.println(Arrays.toString(arreglo));
        
		reloj.start();
		for (int i = 0; i < N_iteraciones; i++) {
			//BubleSelectionSort.burbugeo(arreglo);
			//BubleSelectionSort.selectionSort(arreglo);
			//MergeSort.mergeSort(arreglo);
			//QuickSort.quickSort(arreglo);
			Arrays.sort(arreglo);
		}
        tiempo = reloj.stop();
		System.out.println("Tiempo ordenar el arreglo: " + tiempo); 
        System.out.println(Arrays.toString(arreglo));
		
	}

}
