package backtracking;

import java.util.ArrayList;

/**
 * Ejercicio 8. Colocar un entero positivo (menor que un cierto valor entero k
 * dado) en cada casilla de una pirámide de base B (valor entero dado) de modo
 * que cada número sea igual a la suma de las casillas sobre las que está
 * apoyado. Los números de todas las casillas deben ser diferentes.
 * 
 * @author Gentil Ricardo
 *
 */
public class Backtracking {

	private int K;
	private int base;
	private Integer[][] piramide;

	private int intentos;

	public Backtracking(int K, int base) {
		this.K = K;
		this.base = base;
		this.piramide = new Integer[base][base];
	}

	public Integer[][] generarPiramide() {
		intentos = 0;
		boolean resultado = _generarPiramide(piramide, new ArrayList<Integer>(), 0);
		if (resultado) {
			System.out.println("Se pudo completar");
		} else {
			System.out.println("Naranja lima");
		}
		System.out.println(intentos);
		return piramide;
	}

	private boolean _generarPiramide(Integer[][] piramide, ArrayList<Integer> usados, int indice) {
		intentos++;
		if (indice == base) {
			if (sePudoCompletar(piramide)) {
				return true;
			}
		} else {
			for (Integer i = 1; i <= K; i++) {
				if (!usados.contains(i)) {
					usados.add(i);
					piramide[base - 1][indice] = i;
					indice += 1;
					boolean resultado = _generarPiramide(piramide, usados, indice);
					if (resultado) {
						return true;
					}
					indice -= 1;
					piramide[base -1][indice] = null;
					usados.remove(usados.size() - 1);
				}
			}
		}
		return false;

	}

	private boolean sePudoCompletar(Integer[][] piramide) {
//		if (intentos == 2000) {
//			return true;
//		} else {
//			intentos++;
//			return false;
//		}
		return false;
	}

}
