package main;

import tp1.MySimpleLinkedList;
import util.UtilList;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 6.
	Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
	suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar
	ordenada. b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
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
		
		System.out.println("Union de dos listas desordenadas");
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println("Resultado de la unión");
		System.out.println(UtilList.union(list1, list2));
		
		
		MySimpleLinkedList<Number> list3 = new MySimpleLinkedList<Number>();
		list3.insertLast(1);
		list3.insertLast(5);
		list3.insertLast(8);
		list3.insertLast(9);
		
		MySimpleLinkedList<Number> list4 = new MySimpleLinkedList<Number>();
		list4.insertLast(5);
		list4.insertLast(8);
		list4.insertLast(9);
		list4.insertLast(19);
		list4.insertLast(29);
		
		System.out.println("Union de dos listas ordenadas");
		System.out.println(list3);
		System.out.println(list4);
		
		System.out.println("Resultado de la unión");
		System.out.println(UtilList.unionOrderList(list3, list4));

	}

}
