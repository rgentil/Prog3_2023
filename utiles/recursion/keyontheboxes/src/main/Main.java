package main;

import java.util.Arrays;

import recursion.*;

public class Main {

	public static void main(String[] args) {
		
		//Encontrar una llave dentro de cajas que están adentro de otras cajas.
		Box b1 = new Box("b1",false);
		Box b11 = new Box("b11",false);
		Box b111 = new Box("b111",false);
		Box b12 = new Box("b12",false);
		
		b1.addBox(b12);
		
		b11.addBox(b111);
		b1.addBox(b11);
		
		Box b2 = new Box("b2",false);
		
		Box b3 = new Box("b3",false);
		Box b31 = new Box("b31",true);
		Box b32 = new Box("b32",false);
		
		b3.addBox(b31);
		b3.addBox(b32);
		
		Box b = new Box("b", false);
		b.addBox(b1);
		b.addBox(b2);
		b.addBox(b3);
		
		System.out.println("La llave se encuentra en la caja: " + Recursion.findKey(b) );
		
		System.out.println("La llave se encuentra en la caja..: " + Recursion.searchForKey(b).getName() );
		
		//System.out.println("La llave se encuentra en la caja: " + Recursion.findKey2(b) );
		
		//Imprimir n veces
		Recursion.imprimir(5);
		
		//Factorial de un número n
		int n = 4;
		System.out.println("\n Factorial de " + n + ": " + Recursion.factorial(n) );
		
		//Sumas los valores de un arreglo
		int[] arreglo = {5,4,6,6,9};
		System.out.println("\n Arreglo para ordenar " + Arrays.toString(arreglo));
		System.out.println("\n Sumar arreglo : " + Recursion.sum(arreglo) );
		
		System.out.println("\n Cantidad de items : " + Recursion.cantItemsArreglo(arreglo,0) );
	}

}
