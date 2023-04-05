package util;

import java.util.Iterator;

import tp1.MySimpleLinkedList;

/**
 * Ejercicio 5.
	A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
	iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
	hora de recorrer la lista de principio a fin si se cuenta con un iterador?
	Hay mejora debido a que no estoy recorriendo en ningún momento la lista original, los accesos son O(1)
 * @author Gentil Ricardo
 *
 * @param <T>
 */
public class Iterator_Iterable<T> implements Iterator<T> {

	private MySimpleLinkedList<T> list;
	private int pos;
	
	public Iterator_Iterable(MySimpleLinkedList<T> value){
		this.list = value;
		this.pos = 0;
	}
	
	@Override
	public boolean hasNext() {
		return !list.isEmpty() && pos < list.size();
	}

	@Override
	public T next() {
		if (this.hasNext()) {
			T tmp = list.get(pos);
			pos++;
			return tmp; 
		}
		return null;
	}

}
