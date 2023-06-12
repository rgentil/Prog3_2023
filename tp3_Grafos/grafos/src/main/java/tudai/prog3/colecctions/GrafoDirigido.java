package tudai.prog3.colecctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
		if (!this.contieneVertice(verticeId)) {
			vertices.put(verticeId, new HashSet<Arco<T>>());
			nroVertices++;
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (this.contieneVertice(verticeId)) {
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
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		List<Integer> adyacentes = new ArrayList<Integer>();
		for (Iterator<Arco<T>> it = vertices.get(verticeId).iterator(); it.hasNext();) {
			Arco<T> arco = (Arco<T>) it.next();
			adyacentes.add(arco.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> arcos = new ArrayList<Arco<T>>();
		for (Iterator<Integer> iterator = this.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			arcos.addAll(vertices.get(vertice));
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return vertices.get(verticeId).iterator();
	}

	@Override
	public void imprimir() {
		for (Iterator<Integer> iteratorV = this.obtenerVertices(); iteratorV.hasNext();) {
			Integer vertice = (Integer) iteratorV.next();
			System.out.print(vertice + ": ");
			for (Iterator<Integer> iteratorA = this.obtenerAdyacentes(vertice); iteratorA.hasNext();) {
				Integer ady = (Integer) iteratorA.next();
				System.out.print(ady + " ");
			}
			System.out.println();
		}
	}
	
	@Override
	public void imprimirPonderado() {
		System.out.println("Grafo ponderado");
		for (Iterator<Integer> iteratorV = this.obtenerVertices(); iteratorV.hasNext();) {
			Integer vertice = (Integer) iteratorV.next();
			System.out.print(vertice + " -> ");
			for (Iterator<Arco<T>> iteratorA = this.obtenerArcos(vertice); iteratorA.hasNext();) {
				Arco<T> ady = (Arco<T>) iteratorA.next();
				System.out.print(ady.getVerticeDestino() + "(" + ady.getEtiqueta() + ") ");
			}
			System.out.println();
		}
	}

}
