package tp1;

import util.Iterator_Iterable;

/**
 * 
 * @author Gentil Ricardo
 *
 * @param <T>
 * 

/*
Ejercicio 5.
A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
hora de recorrer la lista de principio a fin si se cuenta con un iterador?
*/

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		if (!this.isEmpty()) {
			T info = this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
			return info;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.size == 0 && this.first == null;
	}
	
	public T get(int index) {
		if (!isEmpty() && size() > index) {
			Node<T> tmp = this.first;
			for (int i = 0; i <= index && tmp != null; i++) {
				if (i == index) {
					return tmp.getInfo();
				}
				tmp = tmp.getNext();
			}
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	public int indexOf(T info) {
		if (!isEmpty()) {
			for (int i = 0; i < this.size; i++) {
				if (info.equals(this.get(i))) {
					return i;
				}
			}			
		}
		return -1;		
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "Lista vacia";
		}
		System.out.println("-----------Valores en la lista-----------");
		String resultado = "";
		for (int i = 0; i < this.size; i++) {
			resultado += "Pos " + i + " - Valor " + this.get(i)+ " | ";
		}
		
		return resultado;
	}
	
	public Iterator_Iterable<T> getIterator() {
		return new Iterator_Iterable<T>(this);
	}
	
}
