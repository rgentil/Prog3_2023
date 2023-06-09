package viajante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Ejercicio 6 Problema del viajante. Dado un grafo ponderado de ciudades
 * conectadas todas con todas, implemente un algoritmo que brinde una
 * aproximación al problema del viajante
 * 
 * @author Gentil Ricardo
 *
 */
public class Viajante {

	private Grafo<Integer> grafo;

	public Viajante(Grafo<Integer> grafo) {
		this.grafo = grafo;
	}

	public List<Integer> getCaminoViajante(Integer ciudad_inicial) {
		List<Integer> camino = new ArrayList<Integer>();
		Integer ciudad_actual = ciudad_inicial;
		camino.add(ciudad_actual);
		while (camino.size() < grafo.cantidadVertices()) {
			Integer ciudad_mas_cercana = getCiudadMasCercana(camino, ciudad_actual);
			if (ciudad_mas_cercana != null) {
				camino.add(ciudad_mas_cercana);
				ciudad_actual = ciudad_mas_cercana;
			}
		}

		return camino;
	}

	private Integer getCiudadMasCercana(List<Integer> camino, Integer ciudad_actual) {
		int menorPeso = Integer.MAX_VALUE;
		Integer ciudad_mas_cercana = null;
		for (Iterator<?> it = grafo.obtenerArcos(ciudad_actual); it.hasNext();) {
			Arco<?> arcoActual = (Arco<?>) it.next();
			Integer ciudad = arcoActual.getVerticeDestino();
			int peso = (int) arcoActual.getEtiqueta();
			if (!camino.contains(ciudad)) {
				if (peso < menorPeso) {
					menorPeso = peso;
					ciudad_mas_cercana = ciudad;
				}
			}
		}
		return ciudad_mas_cercana;
	}

}
