package util;
/*
Ejercicio 10.
Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso) O(n)
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál? La ocupacion de la memoria por la cantidad de datos. a diferencia de ser iterativo.
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo? Nada
*/
public class UtilRecursivo {
	
	public static boolean isOrdered(Number[] arr) {
		return isOrdered(arr, 0);
	} 
	
	private static boolean isOrdered(Number[] arr, int i) {
		if (arr.length == 0 || arr.length == 1) {
			return true;
		}else {
			if (i >= arr.length -1) {
				return true;
			}else {
				if (arr[i].intValue() > arr[i+1].intValue()) {
					return false;
				}else {
					return isOrdered(arr, i+1);
				} 
			}			
		}		
	}

	public static boolean isPalindroma(String cadena) {
		if (cadena == null) {
			return false;
		}
		return isPalindroma(cadena, 0, cadena.length()-1);
	}
	
	private static boolean isPalindroma(String cadena, int inicio, int fin) {		
		if (inicio > fin) {
			return true;
		}else {
			if (cadena.charAt(inicio) != cadena.charAt(fin)) {
				return false;
			}else {
				return isPalindroma(cadena, inicio+1, fin-1);
			}
		}				
	}

}
