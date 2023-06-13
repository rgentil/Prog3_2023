package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

	private List<String> estaciones;
	private List<String> paradas;
	private int llenar_tanque;

	public Backtracking(List<String> estaciones, int k) {
		this.estaciones = estaciones;
		this.llenar_tanque = k;
	}

	public List<String> back() {
		paradas = new ArrayList<String>();
		String estacion_incial = estaciones.remove(0);
		String estacion_final = estaciones.get(estaciones.size() - 1);
		int cantParadas = Integer.MAX_VALUE;
		_back(llenar_tanque, estacion_incial, estacion_final, estaciones, paradas, cantParadas);
		return paradas;
	}

	private void _back(int k, String estacion_actual, String estacion_final, List<String> estaciones,
			List<String> paradas, int cantParadas) {
		if (estacion_actual.equals(estacion_final)) {
			if (cantParadas < paradas.size()) {
				cantParadas = paradas.size();
			}
		} else {
			String estacion_siguiente = estaciones.remove(0);
			int distancia = distancia(estacion_actual, estacion_siguiente);
			// No paro en esa estacion
			if (distancia <= k) {
				k -= distancia;
				_back(k, estacion_siguiente, estacion_final, estaciones, paradas, cantParadas);
				k += distancia;
			} else {
				// Si es mayor en km paro y lleno el tanque
				paradas.add(estacion_actual);
				_back(llenar_tanque, estacion_actual, estacion_final, estaciones, paradas, cantParadas);
				paradas.remove(paradas.size() - 1);
			}
			estaciones.add(0, estacion_siguiente);
		}
	}

	public List<String> back2() {
		paradas = new ArrayList<String>();
		String estacion_incial = estaciones.remove(0);
		String estacion_final = estaciones.get(estaciones.size() - 1);
		int cantParadas = Integer.MAX_VALUE;
		List<String> pasadas = new ArrayList<String>();
		_back2(llenar_tanque, estacion_incial, estacion_final, estaciones, paradas, cantParadas, pasadas);
		return paradas;
	}

	private void _back2(int k, String estacion_actual, String estacion_final, List<String> estaciones,
			List<String> paradas, int cantParadas, List<String> pasadas) {
		if (estacion_actual.equals(estacion_final)) {
			if (cantParadas < paradas.size()) {
				cantParadas = paradas.size();
			}
		} else {
			for (String estacion : getEstacionesALasQuePuedoLLegarDentroDeK(estacion_actual, k)) {
				if (!pasadas.contains(estacion)) {
					pasadas.add(estacion);

					int distancia = distancia(estacion_actual, estacion);

					// No paro en esa estacion
					_back2(k - distancia, estacion_actual, estacion_final, estaciones, paradas, cantParadas, pasadas);

					// Paro y lleno el tanque.

					paradas.add(estacion);
					_back2(llenar_tanque, estacion, estacion_final, estaciones, paradas, cantParadas, pasadas);

					paradas.remove(paradas.size() - 1);

					pasadas.remove(pasadas.size() - 1);

				}
			}
		}
	}

	/**
	 * Me devuelte todas las estaciones hasta las que puedo llegar con un tanque desde la estacion actual
	 * @param estacion_actual
	 * @param k
	 * @return
	 */
	private List<String> getEstacionesALasQuePuedoLLegarDentroDeK(String estacion_actual, int k) {
		return new ArrayList<String>();
	}

	private int distancia(String e1, String e2) {
		return 0;
	}
}
