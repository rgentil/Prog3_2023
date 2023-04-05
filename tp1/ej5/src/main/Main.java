package main;

import tp1.MySimpleLinkedList;
import util.Iterator_Iterable;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
		Ejercicio 5.
		A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
		iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
		hora de recorrer la lista de principio a fin si se cuenta con un iterador?
	*/
		
	public static void main(String[] args) {
		
		MySimpleLinkedList<Number> list = new MySimpleLinkedList<Number>();
		list.insertFront(2);
		list.insertFront(5);
		list.insertFront(7);
		list.insertFront(1);
		list.insertFront(3);
		
		System.out.println(list);
		
		Iterator_Iterable<Number> iterator = list.getIterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
