package util;

public class UtilRecursivo {
	
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
