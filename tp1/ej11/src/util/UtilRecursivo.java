package util;
/*
Ejercicio 11.
Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente.
*/
public class UtilRecursivo {
	
	public static int findElement(Number[] arr, int element) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		return findElement(arr, element, 0, arr.length-1);
	}
	
	private static int findElement(Number[] arr, int element, int inicio, int fin) {
		if(inicio >= fin) {
			return -1;
		}else {			
			int medio = (inicio + fin) / 2;
			if (arr[medio].intValue() > element) {
				return findElement(arr, element, inicio, medio);
			}else {
				if (arr[medio].intValue() < element) {
					return findElement(arr, element, medio + 1, fin);
				}else {
					return medio;
				}				
			}			
		}
	}

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
