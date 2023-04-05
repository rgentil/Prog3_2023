package tp1;
/**
 * 
 * @author Gentil Ricardo
 *
 * @param <T>
 * 
 * Ejercicio 1.
   Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
   (insertFront, extractFront, isEmpty, size, toString). 
   Agregar también el método: T get(index)
 */
public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null,null);
		if (!this.isEmpty()) {
			this.first.setPrevious(tmp);
		}
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;		
	}
	
	public T extractFront() {		
		if (!this.isEmpty()) {
			T info = this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
			return info;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.size == 0 && this.first == null;
	}
	
	public T get(int index) {
		if (!isEmpty() && size() > index) {
			Node<T> tmp = this.first;
			for (int i = 0; i <= index && tmp != null; i++) {
				if (i == index) {
					return tmp.getInfo();
				}
				tmp = tmp.getNext();
			}
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "Lista vacia";
		}
		System.out.println("-----------Valores en la lista-----------");
		String resultado = "";
		for (int i = 0; i < this.size; i++) {
			resultado += this.get(i) + " | ";
		}
		return resultado;
	}
	
}
