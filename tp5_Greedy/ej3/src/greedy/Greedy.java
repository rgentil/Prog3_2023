package greedy;

/**
 * Ejercicio 3 Maximizar el número de actividades compatibles. Se tienen n
 * actividades que necesitan utilizar un recurso, tal como una sala de
 * conferencias, en exclusión mutua. Cada actividad i tiene asociado un tiempo
 * de comienzo ci y un tiempo de finalización fi de utilización del recurso, con
 * ci < fi. Si la actividad i es seleccionada se llevará a cabo durante el
 * intervalo [ci, fi). Las actividades i y j son compatibles si los intervalos
 * [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El
 * problema consiste en encontrar la cantidad máxima de actividades compatibles
 * entre sí.
 * 
 * @author Gentil Ricardo
 *
 */
public class Greedy {
	Actividad actividades; // Tiene una lista de actividades.
	Recurso recursos; // Recursos, puede ser una lista de recursos, que se a su vez tiene una lista de
						// actividades asignadas

	public Greedy(Actividad actividades, Recurso recursos) {
		this.actividades = actividades;
		this.recursos = recursos;
	}

	public Recurso ordenar() {
		boolean pudoAsignar = true;
		while (pudoAsignar && actividades.hayActividades()) {// Mientras haya actividades para asignar y haya podido
																// asignar
			Actividad actividad = actividades.getMenorComienzo();// Me da la actividad que empieza primero con ci menor
																	// y la quita de
																	// la lista de actividades;
			actividades.quitar(actividad);// Quita la actividad de las actividades, por ahí queda más claro que quitarla
											// arriba
			pudoAsignar = recursos.asignar(actividad);// Asigna una actividad en un recurso que no esté ocupado en la
														// hora de comienzo de la actividad o la hora de "liberacion"
														// del recurso < a la hora de comienzo de la actividad
														// seleccionada
		}

		if (!actividades.hayActividades()) {
			System.out.println("Se asignaron todas las actividades");
		} else {
			System.out.println("No se pudo completar la asignacion de todas las actividades");
		}
		return recursos; // retorno recursos para ver las actividades que fueron asignadas.
	}
}
