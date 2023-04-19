package recursion;

import java.util.Iterator;

public class Recursion {

	//Encontrar una llave dentro de cajas que están adentro de otras cajas.
	
	
	public static String findKey(Box box) {
		if (box.thereAreKey()) {
			return box.getName();
		}else {
			for (Iterator<Box> iterator = box.getBoxes().iterator(); iterator.hasNext();) {
				Box b = (Box) iterator.next();
				return findKey(b);
			}
			return "No se encontró la llave";
		}
	}
	
	public static Box searchForKey(Box box) {
	    if (box.thereAreKey()) {
	        return box;
	    } else { 
	    	if (box.hasBoxesInside()) {
		        for (Box innerBox : box.getBoxes()) {
		            Box result = searchForKey(innerBox);
		            if (result != null) {
		                return result;
		            }
		        }
	    	}
	    }
	    return null; // Key not found
	}

	//Fin Encontrar una llave dentro de cajas que están adentro de otras cajas.
	
	//Imprimir n veces
	public static void imprimir(int n) {
		if (n > 0) {
			System.out.print("-" + n);
			imprimir(n-1);
		}
	}
	
	//Factorial de un número n
	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}
	
	//Sumas los valores de un arreglo
	public static int sum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}else {
			return sumaArreglo(arr,0);
		}
	}
	
	private static int sumaArreglo(int[] arr, int indice) {
		if (indice == arr.length -1) {
			return arr[indice];
		} else {
			return arr[indice] + sumaArreglo(arr, indice+1 );
		}
	}
	
	public static int cantItemsArreglo(int[] arr, int indice) {
		if (indice == arr.length -1) {
			return 1;
		} else {
			return 1 + cantItemsArreglo(arr, indice + 1 );
		}
	}
	

}