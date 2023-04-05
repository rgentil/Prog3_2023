package main;

import tp1.MySimpleLinkedList;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 8.
	Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente
	vinculada.
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	}

}
