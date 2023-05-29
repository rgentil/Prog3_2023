package coleccion;

import java.util.Objects;

/**
 * Ejercicio 2. Dado un laberinto consistente en una matriz cuadrada que tiene
 * en cada posición un valor natural y cuatro valores booleanos, indicando estos
 * últimos si desde esa casilla se puede ir al norte, este, sur y oeste,
 * encontrar un camino de longitud mínima entre dos casillas dadas, siendo la
 * longitud de un camino la suma de los valores naturales de las casillas por
 * las que pasa. Idea: podría representarse el laberinto como una matriz, de
 * objetos, donde cada objeto tiene el valor natural, y cuatro booleanos, uno
 * para cada dirección a la que se permite ir desde allí.
 * 
 * @author Gentil Ricardo
 *
 */
public class Nodo {
	private String nombre;
	private int valor;
	private boolean norte;
	private boolean sur;
	private boolean este;
	private boolean oeste;
	private int fila;
	private int columna;

	public Nodo(String nombre, int fila, int columna, int valor, boolean norte, boolean sur, boolean este,
			boolean oeste) {
		super();
		this.nombre = nombre;
		this.fila = fila;
		this.columna = columna;
		this.valor = valor;
		this.norte = norte;
		this.sur = sur;
		this.este = este;
		this.oeste = oeste;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getValor() {
		return valor;
	}

	public boolean puede_ir_Norte() {
		return norte;
	}

	public boolean puede_ir_Sur() {
		return sur;
	}

	public boolean puede_ir_Este() {
		return este;
	}

	public boolean puede_ir_Oeste() {
		return oeste;
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
		Nodo other = (Nodo) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
