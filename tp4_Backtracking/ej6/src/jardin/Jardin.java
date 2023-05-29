package jardin;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 6. Caballo de Atila. Por donde pisa el caballo de Atila jamás
 * vuelve a crecer el pasto. El caballo fue directamente hacia el jardín de n x
 * n casillas. Empezó su paseo por una casilla cualquiera y volvió a ella, es
 * decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se
 * movió de una casilla a otra vecina en forma horizontal o vertical, pero nunca
 * en diagonal. Por donde pisó el caballo, el pasto jamás volvió a crecer. Luego
 * de terminado el recorrido en algunas casillas todavía había pasto (señal de
 * que en ellas no había estado el caballo). Escriba un algoritmo que deduzca el
 * recorrido completo que hizo el caballo.
 * 
 * @author Gentil Ricardo
 *
 */
public class Jardin {

	private Casilla[][] jardin;
	private int N;

	public Jardin(int N) {
		super();
		this.N = N;
		this.jardin = new Casilla[N][N];
	}

	public void addCasilla(Casilla casilla) {
		this.jardin[casilla.getFila()][casilla.getColumna()] = casilla;
	}

	public Casilla getCasilla(int x, int y) {
		return this.jardin[x][y];
	}

	public void imprimir() {
		System.out.println("Jardin [" + N + "][" + N + "] : ");
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.print("   " + jardin[i][j].getNombre() + " ");
			}
			System.out.println();
		}
	}

	public List<Casilla> casillasADondePuedoIrDesde(Casilla casilla_actual) {
		List<Casilla> casillas = new ArrayList<Casilla>();
		int fila = casilla_actual.getFila();
		int columna = casilla_actual.getColumna();
		// Puedo ir a la arriba
		if (fila > 0) {
			Casilla casilla = this.getCasilla(fila - 1, columna);
			casillas.add(casilla);
		}

		// Puedo ir a la abajo
		if (fila < N-1) {
			Casilla casilla = this.getCasilla(fila + 1, columna);
			casillas.add(casilla);
		}

		// Puedo ir hacia derecha
		if (columna < N-1) {
			Casilla casilla = this.getCasilla(fila, columna + 1);
			casillas.add(casilla);
		}

		// Puedo ir hacia izq
		if (columna > 0) {
			Casilla casilla = this.getCasilla(fila, columna - 1);
			casillas.add(casilla);
		}

		return casillas;

	}

}
