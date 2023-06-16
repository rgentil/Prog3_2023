package main;

import java.util.ArrayList;
import java.util.List;

import backtracking.Backtracking;

public class Main {

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);

		System.out.println("Lista a permutar: " + numeros);

		Backtracking back = new Backtracking(numeros);

		List<List<Integer>> resultado = back.back();
		for (List<Integer> r : resultado) {
			System.out.print("|" + r.toString());
		}

	}

}
