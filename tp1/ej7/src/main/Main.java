package main;

import tp1.MySimpleLinkedList;
import util.UtilList;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 7.
	Escriba una función que dadas dos listas construya otra con los elementos que están en la
	primera pero no en la segunda.
	*/
		
	public static void main(String[] args) {
		
		MySimpleLinkedList<Number> list1 = new MySimpleLinkedList<Number>();
		list1.insertFront(2);
		list1.insertFront(99);
		list1.insertFront(7);
		list1.insertFront(1);
		list1.insertFront(8);
		
		MySimpleLinkedList<Number> list2 = new MySimpleLinkedList<Number>();
		list2.insertFront(5);
		list2.insertFront(2);
		list2.insertFront(1);
		list2.insertFront(1);
		list2.insertFront(3);
		list2.insertFront(7);
		
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println("Resultado de la not intersepcion");
		System.out.println(UtilList.notInterseption(list1, list2));
		
	}

}
