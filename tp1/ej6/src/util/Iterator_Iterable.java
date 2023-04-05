package util;

import java.util.Iterator;

import tp1.Node;

/**
Ejercicio 6.
Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar
ordenada. b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
 * @author Gentil Ricardo
 *
 * @param <T>
 */
public class Iterator_Iterable<T> implements Iterator<T> {

	private Node<T> cursor;
	
	public Iterator_Iterable(Node<T> cursor){//cada vez que lo instancien, decime desde donde arrancan
		this.cursor = cursor;
	}
	
	@Override
	public boolean hasNext() {//Controla que haya elementos para iterar
		return this.cursor != null;
	}

	@Override
	public T next() {
		if (this.hasNext()) {//Devuelve el valor actual y adelanta al siguiente.
			T tmp = this.cursor.getInfo();
			this.cursor = this.cursor.getNext();
			return tmp;
		}
		return null;
	}

	public Number getValue() {
		return (Number) this.cursor.getInfo();
	}

}
