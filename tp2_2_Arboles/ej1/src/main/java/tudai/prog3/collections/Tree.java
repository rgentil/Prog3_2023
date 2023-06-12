package tudai.prog3.collections;

import java.util.ArrayList;
import java.util.List;

/*
 * Ejercicio 1.
Implemente la estructura de Árbol Binario para búsquedas.
Métodos:
● Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List
getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?
//   Integer getRoot(), O(1)
//   boolean hasElem(Integer), O (nlog n) si es un arbol balanceado
//   boolean isEmpty(), O(1) 
//   void insert(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
//   boolean delete(Integer), Caso promedio O(Log N) Peor de los casos O(h) h altura
 * 

 * Ejercicio 2 Dado un árbol binario de búsquedas que almacena números enteros,
 * implementar un algoritmo que retorne la suma de todos los nodos internos del
 * árbol.

 */
public class Tree {

	private Node root;

	public Tree() {
		this.root = null;
	}

	public Integer getRoot() {
		if (!this.isEmpty())
			return null;
		return this.root.getValue();
	}

	private boolean isEmpty() {
		return this.root == null;
	}

	public boolean hasElem(Integer value) {
		return this.hasElem(this.root, value);
	}

	private boolean hasElem(Node node, Integer value) {
		if (this.isEmpty()) {
			return false;
		} else {
			int result = node.getValue().compareTo(value);
			if (result == 0) {
				return true;
			} else {
				if (result > 0) {// Si es mayor Va por derecha
					return hasElem(node.getRight(), value);
				} else {// Si es menor busca por la izquierda
					return hasElem(node.getLeft(), value);
				}
			}
		}
	}

	public void insert(Integer value) {
		Node newNode = new Node(value);
		if (this.isEmpty()) {
			this.root = newNode;
		} else {
			insert(this.root, newNode);
		}
	}

	public void insert(Integer value, String character) {
		Node newNode = new Node(value, character);
		if (this.isEmpty()) {
			this.root = newNode;
		} else {
			insert(this.root, newNode);
		}
	}

	private void insert(Node node, Node newNode) {
		int result = node.getValue().compareTo(newNode.getValue());
		if (result < 0) {
			if (node.getRight() == null) {
				node.setRight(newNode);
			} else {
				insert(node.getRight(), newNode);
			}
		} else {
			if (node.getLeft() == null) {
				node.setLeft(newNode);
			} else {
				insert(node.getLeft(), newNode);
			}
		}

	}

	/**
	 * Se busca el nodo a eliminar y se manejan los diferentes casos posibles para
	 * eliminar el nodo. Si el nodo no tiene hijos, simplemente se elimina. Si el
	 * nodo tiene un solo hijo, se reemplaza el nodo con su hijo. Si el nodo tiene
	 * dos hijos, se encuentra el nodo más a la izquierda del subárbol derecho, se
	 * reemplaza el valor del nodo actual con el valor de ese nodo más a la
	 * izquierda, y se elimina ese nodo más a la izquierda.
	 * 
	 * @param value
	 */
	public void delete(Integer value) {
		root = deleteNode(root, value);
	}

	private Node deleteNode(Node actual, Integer value) {
		if (actual == null) {
			return null;
		}

		int state = value.compareTo(actual.getValue());
		if (state < 0) {
			actual.setLeft(deleteNode(actual.getLeft(), value));
		} else if (state > 0) {
			actual.setRight(deleteNode(actual.getRight(), value));
		} else {
			if (actual.getLeft() == null) {
				return actual.getRight();
			} else if (actual.getRight() == null) {
				return actual.getLeft();
			}

			Integer valueMoreLeft = findNodeMoreLeft(actual.getRight());
			actual.setValue(valueMoreLeft);
			actual.setRight(deleteNode(actual.getRight(), actual.getValue()));
		}

		return actual;
	}

	private Integer findNodeMoreLeft(Node node) {
		if (node.getLeft() == null) {
			return node.getValue();
		}
		return findNodeMoreLeft(node.getLeft());
	}

	/**
	 * Se obtienen las alturas de ambos subárboles, y se devuelve el máximo de estas
	 * alturas más uno (para contar el nodo actual). El caso base es cuando el nodo
	 * es nulo, en cuyo caso se devuelve cero.
	 * 
	 * @return altura máxima del árbol
	 */
	public int getHeight() {
		return getHeightTree(root);
	}

	private int getHeightTree(Node node) {
		if (node == null) {
			return 0;
		}
		int heightLeft = getHeightTree(node.getLeft());
		int heightRight = getHeightTree(node.getRight());
		return Math.max(heightLeft, heightRight) + 1;
	}

	/**
	 * Si el nodo es una hoja, se compara la lista de la rama actual con la lista de
	 * la rama más larga encontrada hasta el momento, y se actualiza la lista de la
	 * rama más larga si la rama actual es más larga. Después de visitar un nodo y
	 * sus hijos, se elimina el valor del nodo actual de la lista de la rama actual
	 * para retroceder un nivel en el árbol.
	 * 
	 * @return Lista con los nodos de la rama más larga
	 */
	public List<Integer> getLongestBranch() {
		List<Integer> actualBranch = new ArrayList<>();
		List<Integer> longestBranch = new ArrayList<>();
		getLongestBranch(root, actualBranch, longestBranch);
		return longestBranch;
	}

	private void getLongestBranch(Node node, List<Integer> actualBranch, List<Integer> longestBranch) {
		if (node == null) {
			return;
		}
		actualBranch.add(node.getValue());
		if (node.isLeaft()) {
			if (actualBranch.size() > longestBranch.size()) {
				longestBranch.clear();
				longestBranch.addAll(actualBranch);
			}
		}
		getLongestBranch(node.getLeft(), actualBranch, longestBranch);
		getLongestBranch(node.getRight(), actualBranch, longestBranch);
		actualBranch.remove(actualBranch.size() - 1);
	}

	public List<Integer> getFrontier() {
		List<Integer> frontier = new ArrayList<Integer>();
		getFrontier(root, frontier);
		return frontier;
	}

	private void getFrontier(Node node, List<Integer> frontier) {
		if (node == null) {
			return;
		}
		if (node.isLeaft()) {
			frontier.add(node.getValue());
		}
		getFrontier(node.getLeft(), frontier);
		getFrontier(node.getRight(), frontier);
	}

	public Integer getMaxElem() {
		return getMaxElem(root);
	}

	private Integer getMaxElem(Node node) {
		if (node == null) {
			return null;
		}
		if (node.getRight() == null) {
			return node.getValue();
		}
		return getMaxElem(node.getRight());
	}

	public List<Integer> getElemAtLevel(int level) {
		List<Integer> listElements = new ArrayList<Integer>();
		getElemAtLevel(root, 0, level, listElements);
		return listElements;
	}

	private void getElemAtLevel(Node node, int actualLevel, int level, List<Integer> listElements) {
		if (node == null) {
			return;
		}
		if (actualLevel == level) {
			listElements.add(node.getValue());
		}
		actualLevel += 1;
		getElemAtLevel(node.getLeft(), actualLevel, level, listElements);
		getElemAtLevel(node.getRight(), actualLevel, level, listElements);
		actualLevel -= 1;
	}

	/*
	 * Ejercicio 2 Dado un árbol binario de búsquedas que almacena números enteros,
	 * implementar un algoritmo que retorne la suma de todos los nodos internos del
	 * árbol.
	 */
	public int sum() {
		return sum(root);
	}

	private int sum(Node node) {
		if (node == null) {
			return 0;
		}
		return node.getValue() + sum(node.getLeft()) + sum(node.getRight());
	}

	/*
	 * Ejercicio 3 Dado un árbol binario de búsqueda que almacena números enteros y
	 * un valor de entrada K, implementar un algoritmo que permita obtener un
	 * listado con los valores de todas las hojas cuyo valor supere K. Por ejemplo,
	 * para el árbol de la derecha, con un valor K = 8, el resultado debería ser [9,
	 * 11].
	 */
	public List<Integer> getLeavesGreaterThan(int k) {
		List<Integer> list = new ArrayList<Integer>();
		getLeavesGreaterThan(root, k, list);
		return list;
	}

	private void getLeavesGreaterThan(Node node, int k, List<Integer> list) {
		if (node == null) {
			return;
		}
		if (node.isLeaft()) {
			if (node.getValue() >= k) {
				list.add(node.getValue());
			}
		}
		getLeavesGreaterThan(node.getLeft(), k, list);
		getLeavesGreaterThan(node.getRight(), k, list);
	}

	public void printPosOrder() {
		if (isEmpty()) {
			System.out.println("Arbol vacío");
		} else {
			System.out.println("\nImpresión Pos Order");
			printPosOrder(this.root);
		}
	}

	private void printPosOrder(Node node) {
		if (node != null) {
			printPosOrder(node.getLeft());
			printPosOrder(node.getRight());
			System.out.print(" - " + node.getValue());
		}
	}

	public void printPreOrder() {
		if (isEmpty()) {
			System.out.println("Arbol vacío");
		} else {
			System.out.println("\nImpresión Pre Order");
			printPreOrder(this.root);
		}
	}

	private void printPreOrder(Node node) {
		if (node != null) {
			if (node.hasCharacter()) {
				System.out.print(" - " + node.getValue() + "|" + node.getCharacter());
			} else {
				System.out.print(" - " + node.getValue());
			}
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}

	public void printInOrder() {
		if (isEmpty()) {
			System.out.println("Arbol vacío");
		} else {
			System.out.println("\nImpresión Pos Order");
			printInOrder(this.root);
		}
	}

	private void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.print(" - " + node.getValue());
			printInOrder(node.getRight());
		}
	}

	public void print() {
		printPreOrder();
		System.out.println("------------------------------------------------------------------");
		printTree(root, 0);
	}

	private void printTree(Node node, int depth) {
		if (node == null) {
			return;
		}
		printTree(node.getRight(), depth + 1);
		for (int i = 0; i < depth; i++) {
			System.out.print("    ");
		}
		if (node.hasCharacter()) {
			System.out.println(node.getValue() + "|" + node.getCharacter());
		} else {
			System.out.println(node.getValue());
		}
		printTree(node.getLeft(), depth + 1);
	}

	/*
	 * EJERCICIO 4 Se posee un árbol binario (no de búsqueda), donde los nodos
	 * internos están vacíos, mientras que las hojas tienen valores enteros. Se debe
	 * implementar un método que recorra el árbol y coloque valores en los nodos
	 * vacíos (los nodos internos). El valor de cada nodo interno debe ser igual al
	 * valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que
	 * el nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0.
	 * Por ejemplo, tomando como entrada el árbol de la izquierda, el árbol
	 * resultante debería quedar con los mismos valores que el de la derecha.
	 * 
	 * 11 "" 9 "" 7 "" 4 "" 1
	 */

	public void setPreEj4() {
		setPreEj4(root);
	}

	private void setPreEj4(Node node) {
		if (node == null) {
			return;
		}
		if (!node.isLeaft()) {
			node.setValue(null);
		}
		setPreEj4(node.getLeft());
		setPreEj4(node.getRight());
	}

	public void completeNode() {
		completeNode(root);
	}

	private void completeNode(Node node) {
		if (node == null) {
			return;
		}
		if (node.isLeaft()) {
			return;
		}
		completeNode(node.getLeft());
		completeNode(node.getRight());
		int valueLeft = (node.getLeft() == null) ? 0 : node.getLeft().getValue();
		int valueRigth = (node.getRight() == null) ? 0 : node.getRight().getValue();
		node.setValue(valueLeft - valueRigth);
	}

	/*
	 * Ejercicio 5 Dado un árbol binario donde todos los nodos poseen un carácter,
	 * de manera que cada rama del árbol contiene una palabra, implementar un
	 * algoritmo que busque y retorne todas las palabras que posea exactamente N
	 * vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con una
	 * entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N
	 * = 2, debería retornar [“MANA”, “MANO”, “MISA”].
	 */

	// Devolver todas las ramas para probar e investigar para llegar al resultado
	// final
	public List<List<Integer>> getBranches() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> listAux = new ArrayList<Integer>();
		getBranches(root, listAux, result);
		return result;
	}

	private void getBranches(Node node, List<Integer> listAux, List<List<Integer>> result) {
		if (node == null) {
			return;
		}
		listAux.add(node.getValue());
		if (node.isLeaft()) {
			result.add(new ArrayList<Integer>(listAux));
		} else {
			getBranches(node.getLeft(), listAux, result);
			getBranches(node.getRight(), listAux, result);
		}
		listAux.remove(listAux.size() - 1);
	}

	public List<List<String>> getBranchesOfNVowels(int N) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> listAux = new ArrayList<String>();
		getBranchesOfNVowels(root, listAux, result, N);
		return result;
	}

	private void getBranchesOfNVowels(Node node, List<String> listAux, List<List<String>> result, int N) {
		if (node == null) {
			return;
		}
		listAux.add(node.getCharacter());
		if (node.isLeaft()) {
			if (totalWowels(listAux) == N) {
				result.add(new ArrayList<String>(listAux));
			}
		} else {
			getBranchesOfNVowels(node.getLeft(), listAux, result, N);
			getBranchesOfNVowels(node.getRight(), listAux, result, N);
		}

		listAux.remove(listAux.size() - 1);
	}

	private int totalWowels(List<String> listAux) {
		int total = 0;
		for (String c : listAux) {
			if (c == "A" || c == "E" || c == "I" || c == "O" || c == "U") {
				total++;
			}
		}
		return total;
	}

}
