package tp;

/*
Ejercicio 3.
Implemente una Pila utilizando la Lista del ejercicio 
1. A una pila se le pueden agregar elementos utilizando el m�todo push(T o). 
2. Para retirar elementos de la colecci�n se utiliza el m�todo pop(), que retorna el �ltimo elemento agregado a la colecci�n y lo elimina de la
misma. 
3. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el m�todo top(). 
4. Por �ltimo, es posible invertir el orden de los elementos de la pila mediante el m�todo reverse().
*/

public class Stuck<T> {
	
	private MySimpleLinkedList<T> stuck;
	
	public Stuck() {
		stuck = new MySimpleLinkedList<T>();
	}

	public void push(T value) {
		stuck.insertFront(value);
	}
	
	public T pop() {
		return stuck.extractFront();
	}
	
	public T top() {
		return stuck.get(0);
	}
	
	public void reverse() {
		MySimpleLinkedList<T> tmp = new MySimpleLinkedList<T>();
		for (int i = 0; i< stuck.size(); i++ ) {
			tmp.insertFront(stuck.get(i));
		}
		stuck = tmp;
	}
	
	public String toString () {
		//return stuck.toString();
		
		if (stuck.isEmpty()) {
			return "Pila vacia";
		}
		System.out.println("-----------Pila-----------");
		String resultado = "";
		for (int i = 0; i < stuck.size(); i++) {
			resultado += "|" + stuck.get(i)+ " | \n";
			
		}
		
		return resultado;
		
	}
	
}
