package Coleccion;

import java.util.Objects;

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
