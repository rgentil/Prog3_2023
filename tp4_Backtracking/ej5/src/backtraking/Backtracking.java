package backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ejercicio 5. Asignación de tareas a procesadores. Se tienen m procesadores
 * idénticos y n tareas con un tiempo de ejecución dado. Se requiere encontrar
 * una asignación de tareas a procesadores de manera de minimizar el tiempo de
 * ejecución del total de tareas.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private List<Tarea> tareas;
	private List<Tarea> procesador1;
	private List<Tarea> procesador2;
	private List<Tarea> procesador3;
	private Number mejorTiempo;

	private List<List<Tarea>> procesadores;

	public Backtracking(List<Tarea> tareas) {
		super();
		this.tareas = tareas;
		this.procesador1 = new ArrayList<Tarea>();
		this.procesador2 = new ArrayList<Tarea>();
		this.procesador3 = new ArrayList<Tarea>();
	}

	public Backtracking(List<Tarea> tareas, List<List<Tarea>> procesadores) {
		super();
		this.tareas = tareas;
		this.procesadores = procesadores;
	}

	public List<List<Tarea>> asignarNProcesadores() {
		List<List<Tarea>> resultado = new ArrayList<List<Tarea>>();
		mejorTiempo = null;
		_asignarNProcesadores(tareas, procesadores, resultado);
		return resultado;
	}

	private void _asignarNProcesadores(List<Tarea> tareas, List<List<Tarea>> procesadores,
			List<List<Tarea>> resultado) {
		if (tareas.isEmpty()) {
			int tiempoActual = getTiempoProcesamiento(procesadores);
			if (mejorTiempo == null || tiempoActual < mejorTiempo.intValue()) {
				mejorTiempo = tiempoActual;
				resultado.clear();
				// resultado.addAll(procesadores);
				for (List<Tarea> p : procesadores) {
					resultado.add(new ArrayList<Tarea>(p));
				}
			}
		} else {
			Tarea t = tareas.remove(0);
			for (List<Tarea> procesador : procesadores) {
				if (!procesador.contains(t)) {
					procesador.add(t);
					_asignarNProcesadores(tareas, procesadores, resultado);
					procesador.remove(procesador.size() - 1);
				}
			}
			tareas.add(0, t);
		}

	}

	public List<List<Tarea>> asignar() {
		List<List<Tarea>> resultado = new ArrayList<List<Tarea>>();
		mejorTiempo = null;
		_asignar(tareas, procesador1, procesador2, procesador3, resultado);
		return resultado;
	}

	private void _asignar(List<Tarea> tareas, List<Tarea> procesador1, List<Tarea> procesador2, List<Tarea> procesador3,
			List<List<Tarea>> resultado) {
		if (tareas.isEmpty()) {
			int tiempoActual = getTiempoProcesamiento(procesador1, procesador2, procesador3);
			if (mejorTiempo == null || tiempoActual < mejorTiempo.intValue()) {
				mejorTiempo = tiempoActual;
				resultado.clear();
				resultado.add(new ArrayList<Tarea>(procesador1));
				resultado.add(new ArrayList<Tarea>(procesador2));
				resultado.add(new ArrayList<Tarea>(procesador3));
			}
		} else {
			Tarea t = tareas.remove(0);
			procesador1.add(t);
			_asignar(tareas, procesador1, procesador2, procesador3, resultado);
			tareas.add(0, t);
			procesador1.remove(procesador1.size() - 1);

			tareas.remove(0);
			procesador2.add(t);
			_asignar(tareas, procesador1, procesador2, procesador3, resultado);
			tareas.add(0, t);
			procesador2.remove(procesador2.size() - 1);

			tareas.remove(0);
			procesador3.add(t);
			_asignar(tareas, procesador1, procesador2, procesador3, resultado);
			tareas.add(0, t);
			procesador3.remove(procesador3.size() - 1);
		}
	}

	private int getTiempoProcesamiento(List<Tarea> procesador1, List<Tarea> procesador2, List<Tarea> procesador3) {

		int[] totales = new int[3];
		int total = 0;

		for (Tarea t : procesador1) {
			total += t.getTiempo();
		}
		totales[0] = total;

		total = 0;
		for (Tarea t : procesador2) {
			total += t.getTiempo();
		}
		totales[1] = total;

		for (Tarea t : procesador3) {
			total += t.getTiempo();
		}
		totales[2] = total;

		Arrays.sort(totales);

		int numero = totales[2];
		for (int i = 0; i < totales.length - 1; i++) {
			numero -= totales[i];
		}

		return numero;
	}

	private int getTiempoProcesamiento(List<List<Tarea>> procesadores) {

		int total = 0;
		int indice = 0;
		int[] totales = new int[procesadores.size()];
		for (List<Tarea> procesador : procesadores) {
			for (Tarea t : procesador) {
				total += t.getTiempo();
			}
			totales[indice] = total;
			total = 0;
			indice++;
		}

		Arrays.sort(totales);

		int numero = totales[procesadores.size() - 1];
		for (int i = 0; i < totales.length - 1; i++) {
			numero -= totales[i];
		}

		return numero;
	}

}
