package backtraking;

import java.util.Objects;

public class Tarea {

	private String nombre;
	private int tiempo;

	public Tarea(String nombre, int tiempo) {
		super();
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Tarea [nombre=" + nombre + ", tiempo=" + tiempo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
