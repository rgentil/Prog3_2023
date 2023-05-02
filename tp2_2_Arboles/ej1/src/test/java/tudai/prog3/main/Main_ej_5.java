package tudai.prog3.main;

import tudai.prog3.collections.Tree;

public class Main_ej_5 {
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		/*Integer[] arr = { 6, 2, 1, 4, 10, 8, 11, 7, 9 };
		for (Integer value : arr) {
			tree.insert(value);
		}*/
		
		tree.insert(6,"M");
		tree.insert(1,"A");
		tree.insert(0,"L");
		tree.insert(3,"N");
		tree.insert(2,"A");
		tree.insert(4,"O");
		tree.insert(9,"I");
		tree.insert(7,"S");
		tree.insert(8,"A");
		tree.insert(10,"O");

		tree.print();
		System.out.println("Ramas de 0 vocales " + tree.getBranchesOfNVowels(0).toString());
		System.out.println("Ramas de 1 vocales " + tree.getBranchesOfNVowels(1).toString());
		System.out.println("Ramas de 2 vocales " + tree.getBranchesOfNVowels(2).toString());
		System.out.println("Ramas de 3 vocales " + tree.getBranchesOfNVowels(3).toString());
	}

}
