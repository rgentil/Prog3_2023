package tudai.prog3.colecctions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, HashSet<Arco<T>>> vertices;
	private int nroVertices;
	private int nroArcos;

	public GrafoDirigido() {
		super();
		vertices = new HashMap<Integer, HashSet<Arco<T>>>();
		nroVertices = 0;
		nroArcos = 0;
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			vertices.put(verticeId, new HashSet<Arco<T>>());
			nroVertices++;
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (vertices.containsKey(verticeId)) {
			for (Iterator<Arco<T>> it = vertices.get(verticeId).iterator(); it.hasNext();) {
				Arco<T> arco = (Arco<T>) it.next();
				this.borrarArco(verticeId, arco.getVerticeDestino());
			}
			vertices.remove(verticeId);
			nroVertices--;
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		this.agregarVertice(verticeId1);
		this.agregarVertice(verticeId2);
		Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		(this.vertices.get(verticeId1)).add(arco);
		nroArcos++;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> arco = new Arco<T>(verticeId1, verticeId2, null);
		vertices.get(verticeId1).remove(arco);
		nroArcos--;
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return this.obtenerArco(verticeId1, verticeId2) == null ? false : true;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		for (Iterator<Arco<T>> it = vertices.get(verticeId1).iterator(); it.hasNext();) {
			Arco<T> arco = (Arco<T>) it.next();
			if (arco.getVerticeDestino() == verticeId2) {
				return arco;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.nroVertices;
	}

	@Override
	public int cantidadArcos() {
		return this.nroArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
