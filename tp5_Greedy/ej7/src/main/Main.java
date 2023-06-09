package main;

import greedy.Greedy;

/**
 * Ejercicio 7 Atrapando leones. Dado un arreglo donde en cada posición se
 * encuentra un cazador o un león, queremos capturar la mayor cantidad de leones
 * sabiendo que: ● Un cazador solo puede atrapar un león, ● Los cazadores sólo
 * pueden capturar leones que estén a menos de K pasos de su posición.
 * 
 * @author Gentil Ricardo
 *
 */
public class Main {

	public static void main(String[] args) {
		int k = 1;
		Greedy greedy = new Greedy(k);

		System.out.println("Cantidad de lones cazados: " + greedy.cazar());

	}

}
