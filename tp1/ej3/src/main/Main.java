package main;

import tp.Stuck;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Ejercicio 3.
	Implemente una Pila utilizando la Lista del ejercicio 
	1. A una pila se le pueden agregar elementos utilizando el método push(T o). 
	2. Para retirar elementos de la colección se utiliza el método pop(), que retorna el último elemento agregado a la colección y lo elimina de la
	misma. 
	3. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el método top(). 
	4. Por último, es posible invertir el orden de los elementos de la pila mediante el método reverse().
	*/
	
	public static void main(String[] args) {
		Stuck<Number> stuck = new Stuck<Number>();
		
		stuck.push(1);
		stuck.push(2);
		stuck.push(3);
		stuck.push(4);
		
		System.out.println(stuck.toString());
		System.out.println("Tope de la pila: " + stuck.top());
		System.out.println("Valor eliminado del tope: " + stuck.pop());
		System.out.println("Tope de la pila: " + stuck.top());
		System.out.println(stuck.toString());
		
		stuck.reverse();
		
		System.out.println(stuck.toString());
		System.out.println("Tope de la pila: " + stuck.top());
		
	}

}
