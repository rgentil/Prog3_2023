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
	1. A una pila se le pueden agregar elementos utilizando el m�todo push(T o). 
	2. Para retirar elementos de la colecci�n se utiliza el m�todo pop(), que retorna el �ltimo elemento agregado a la colecci�n y lo elimina de la
	misma. 
	3. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el m�todo top(). 
	4. Por �ltimo, es posible invertir el orden de los elementos de la pila mediante el m�todo reverse().
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
