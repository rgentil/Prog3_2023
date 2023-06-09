package greedy;

/**
 * Ejercicio 7 Atrapando leones. Dado un arreglo donde en cada posición se
 * encuentra un cazador o un león, queremos capturar la mayor cantidad de leones
 * sabiendo que: ● Un cazador solo puede atrapar un león, ● Los cazadores sólo
 * pueden capturar leones que estén a menos de K pasos de su posición.
 * 
 * @author Gentil Ricardo
 *
 */

public class Greedy {
	private int k;
	private Integer[] africa = { 2, 0, 0, 1, 1, 0, 2, 1, 0, 2 };// Los 1 son cazadores los 2 leones 0 espacios
	// vacios.

	public Greedy(int k) {
		this.k = 3;
	}

	public int cazar() {
		int nroLeonesCazados = 0;
		int i = 0;
		while (i < africa.length) {
			if (africa[i] == 1) {
				if (matoLeonMasCercano(i)) {
					nroLeonesCazados += 1;
				}
			}
			i++;
		}
		return nroLeonesCazados;
	}

	private boolean matoLeonMasCercano(int i) {
		boolean mato = false;
		int posIzq = i - 1;
		int pasosIzq = 1;
		boolean encontroLeonALaIzquierda = false;
		while (!encontroLeonALaIzquierda && posIzq >= 0 && pasosIzq <= k) {
			if (africa[posIzq] == 2) {
				encontroLeonALaIzquierda = true;
			} else {
				posIzq -= 1;
				pasosIzq += 1;
			}
		}

		int posDer = i + 1;
		int pasosDer = 1;
		boolean encontroLeonALaDerecha = false;
		while (!encontroLeonALaDerecha && posDer < africa.length && pasosDer <= k) {
			if (africa[posDer] == 2) {
				encontroLeonALaDerecha = true;
			} else {
				posDer += 1;
				pasosDer += 1;
			}
		}

		if (encontroLeonALaIzquierda && encontroLeonALaDerecha) {
			if (pasosDer >= pasosIzq) {
				africa[posIzq] = 0;
			}else {
				africa[posDer] = 0;	
			}
			
			mato = true;
		}

		if (!encontroLeonALaIzquierda && encontroLeonALaDerecha) {
			africa[posDer] = 0;
			mato = true;
		}

		if (encontroLeonALaIzquierda && !encontroLeonALaDerecha) {
			africa[posIzq] = 0;
			mato = true;
		}
		return mato;

	}
}