package tudai.prog3.main;

import tudai.prog3.collections.Tree;

/*
EJERCICIO 4
Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe
ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el
nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por ejemplo, tomando
como entrada el árbol de la izquierda, el árbol resultante debería quedar con los mismos
valores que el de la derecha.

        11
    ""
            9
        ""
            7
""
        4
    ""
        1
*/
public class Main_ej_4 {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		Integer[] arr = { 6, 2, 1, 4, 10, 8, 11, 7, 9 };
		for (Integer value : arr) {
			tree.insert(value);
		}

		tree.print();
		tree.setPreEj4();
		tree.print();
		tree.completeNode();
		tree.print();
	}

}
