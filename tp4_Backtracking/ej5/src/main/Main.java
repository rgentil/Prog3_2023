package main;

import java.util.ArrayList;
import java.util.List;
import backtraking.Backtracking;
import backtraking.Tarea;

/**
 * Ejercicio 5. Asignación de tareas a procesadores. Se tienen m procesadores
 * idénticos y n tareas con un tiempo de ejecución dado. Se requiere encontrar
 * una asignación de tareas a procesadores de manera de minimizar el tiempo de
 * ejecución del total de tareas.
 * 
 * @author Gentil Ricardo
 *
 */

public class Main {

	public static void main(String[] args) {
		Tarea t1 = new Tarea("T1", 3);
		Tarea t2 = new Tarea("T2", 2);
		Tarea t3 = new Tarea("T3", 1);
		Tarea t4 = new Tarea("T4", 1);

		List<Tarea> tareas = new ArrayList<Tarea>();

		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);

		Backtracking backtracking = new Backtracking(tareas);

		List<List<Tarea>> resultado = backtracking.asignar();
		for (List<Tarea> procesador : resultado) {
			System.out.println("Resultado : " + procesador.toString());
		}

		System.out.println("------------------------------------");

		List<List<Tarea>> procesadores = new ArrayList<List<Tarea>>();
		procesadores.add(new ArrayList<Tarea>());
		procesadores.add(new ArrayList<Tarea>());
		procesadores.add(new ArrayList<Tarea>());

		Backtracking backtracking2 = new Backtracking(tareas, procesadores);

		List<List<Tarea>> resultado2 = backtracking2.asignarNProcesadores();
		for (List<Tarea> procesador : resultado2) {
			System.out.println("Resultado2 : " + procesador.toString());
		}

	}

}
