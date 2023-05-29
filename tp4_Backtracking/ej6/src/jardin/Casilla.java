package jardin;

import java.util.Objects;

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
public class Casilla {
	private String nombre;
	private int fila;
	private int columna;

	public Casilla(int f, int c) {
		super();
		this.nombre = "(" + f + "," + c + ")";
		this.fila = f;
		this.columna = c;
	}

	public String getNombre() {
		return nombre;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casilla other = (Casilla) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
