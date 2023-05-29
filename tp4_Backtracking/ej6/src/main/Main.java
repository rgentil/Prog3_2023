package main;

import java.util.List;

import backtracking.Backtracking;
import jardin.Casilla;
import jardin.Jardin;

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
public class Main {

	public static void main(String[] args) {
		Jardin jardin = new Jardin(3);

		jardin.addCasilla(new Casilla(0, 0));
		jardin.addCasilla(new Casilla(0, 1));
		jardin.addCasilla(new Casilla(0, 2));

		jardin.addCasilla(new Casilla(1, 0));
		jardin.addCasilla(new Casilla(1, 1));
		jardin.addCasilla(new Casilla(1, 2));

		jardin.addCasilla(new Casilla(2, 0));
		jardin.addCasilla(new Casilla(2, 1));
		jardin.addCasilla(new Casilla(2, 2));

		jardin.imprimir();

		System.out.println("");

		Backtracking backtracking = new Backtracking(jardin);

		System.out.println("");
		Casilla inicio = new Casilla(0, 1);
		System.out.println("Inicio por " + inicio.getNombre());

		List<List<Casilla>> caminos_recorridos = backtracking.getCaminoDelCaballoDeAtila(inicio);

		System.out.println("Caminos recorrido: ");
		int i = 1;
		for (List<Casilla> camino : caminos_recorridos) {
			System.out.println("Camino " + i + ": " + camino.toString());
			i++;
		}

	}

}
