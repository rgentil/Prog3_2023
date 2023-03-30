package main;

import tp1.MySimpleLinkedList;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 4.
	A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
	indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
	-1 si el elemento no existe en la lista.
	*/
		
	public static void main(String[] args) {
		
		MySimpleLinkedList<Number> list = new MySimpleLinkedList<Number>();
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		list.insertFront(2);
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		System.out.println("ExtractFront: " + list.extractFront());
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		list.insertFront(5);
		list.insertFront(7);
		list.insertFront(1);
		list.insertFront(3);
		
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		int index = 2;
		System.out.println("Value in index " + index + ": " + list.get(index));
		
		System.out.println(list);
		
		int valor = 50;
		System.out.println("El elemento " + valor + "se ecuetra en la pos.: " + list.indexOf(valor));

	}

}
