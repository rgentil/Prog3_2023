package tp1;

import util.Iterator_Iterable;

/**
 * 
 * @author Gentil Ricardo
 *
 * @param <T>
 * 
 * 
 *            /* Ejercicio 6. Escriba un procedimiento que dadas dos listas
 *            construya otra con los elementos comunes, suponiendo que: a) Las
 *            listas están desordenadas y la lista resultante debe quedar
 *            ordenada. b) Las listas están ordenadas y la lista resultante debe
 *            mantenerse ordenada.
 */

public class MySimpleLinkedList<T> {

	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public void insertLast(T info) {
		if (this.isEmpty()) {
			this.insertFront(info);
		}else {
			Node<T> tmp = new Node<T>(info, null);
			this.getNode(size-1).setNext(tmp);
			this.size++;
		}
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
			resultado += this.get(i) + " | ";
		}
		return resultado;
	}
	
	public Iterator_Iterable<T> getIterator() {
		return new Iterator_Iterable<T>(this.getNode(0));
	}

	public boolean contains(T value) {
		return this.indexOf(value) == -1 ? false : true;
	}

	public Node<T> getNode(int index) {
		if (!isEmpty() && size() > index) {
			Node<T> tmp = this.first;
			for (int i = 0; i <= index && tmp != null; i++) {
				if (i == index) {
					return tmp;
				}
				tmp = tmp.getNext();
			}
		}
		return null;
	}

	public void insertInOrden(T value) {
		if (this.isEmpty()) {//Si es vacío inserto comun
			insertFront(value);
		} else {
			Node<T> newNode = new Node<T>(value, null);
			if (this.size == 1) {//Si hay solo un elemento, comparo.
				Node<T> actualNode = this.getNode(0);
				if (((Number) actualNode.getInfo()).longValue() >= ((Number) newNode.getInfo()).longValue()) {
					this.insertFront(value);
				} else {
					actualNode.setNext(newNode);
					this.size++;
				}
			} else {//Si hay mas de 1 elemento, comparo el nodo actual, el nodo siguiente y el valor a insertar
				for (int i = 0; i < this.size; i++) {
					Node<T> actualNode = this.getNode(i);
					if (i == 0) {
						if (((Number) actualNode.getInfo()).longValue() >= ((Number) newNode.getInfo()).longValue()) {
							this.insertFront(value);
						} else {
							Node<T> nextNode = actualNode.getNext();
							if (((Number) nextNode.getInfo()).longValue() >= ((Number) newNode.getInfo()).longValue()) {
								newNode.setNext(nextNode);
								actualNode.setNext(newNode);	
								this.size++;
							}
						}
					}
				}
			}
		}
	}

}
