Hashing

Guardar un dato clave y ayudar a la busqueda de los datos. Y asociar el resto de la informacion

Mediante esa clave se recuperan datos.

Se requiere un mecanismo de acceso asociativo. 

Hasta el momento
	– Array ordenado: Log2(N) (búsqueda binaria)
	– Árbol binario ordenado: Log2 (N) (balanceado)
	– Árboles n-arios de orden p = Log p (N) (balanceados)
	
Definimos una función h (llamada función de hashing) que, dada una clave de búsqueda x, determine la posición de almacenamiento de sus datos asociados.
Se aporta x, se aplica h(x) → posición de los datos asociados a x
La idea de las estructuras de dispersión es llevar este tiempo de búsqueda a O(1) o cercano, utilizando las técnicas de dispersión o hashing.
Es una estructura particularmente valiosa en aplicaciones con una frecuencia de búsquedas muy alta, donde el tiempo de búsqueda sea crítico.

Conceptos
	▪ x: clave de búsqueda perteneciente al dominio estructurante.
	▪ h(x) función que convierte un elemento del dominio estructurante en un elemento
		del espacio de almacenamiento → direccionamiento por contenido
	▪ Espacio de almacenamiento dividido en M baldes.
	▪ Cada balde puede contener lugar para albergar más de un elemento → cada uno
		es llamado ranura.
	▪ La función de hashing más utilizada es h(x)= x mod M. (el resto de la división x/M)
	▪ Generalmente se elige M como un número primo ya que la función mod dispersa
		los datos de manera más uniforme.
		
Característica de las estructuras de hashing:
	─ No existe un ordenamiento físico de los datos (se encuentran dispersos por toda la estructura).
	─ Facilita la inserción y eliminación rápida de registros por la clave de búsqueda x.
	─ La búsqueda asociativa, es decir aportar la clave x y recuperar el resto de los datos que la acompañan, en promedio tiene un costo muy bajo
		(cercano a 1)
	─ Se dan dos situaciones dependiendo de cómo distribuye los datos la función de hashing:
	
	Hashing Perfecto
		También conocido como distribución perfecta o direccionamiento directo.
		La función de hash define una dirección del espacio de almacenamiento diferente para cada elemento del dominio estructurante, o sea
		∀ 𝑋1 ≠ 𝑋2 ⇒ f(𝑋1) ≠ f(𝑋2)
		Hay una función que transforma una clave de búsqueda en una posición única, que no será asignada a ningún otro elemento.
		Son difíciles de definir → Se aplica a dominios con regularidades matemáticas que puedan ser explotadas (ej. arreglos multidimensionales).
		Si se logra definir, encontrar un elemento requiere un solo acceso ya que o está en el lugar dado por la función o no está almacenado.
		Siempre es rp = 1, sino se esta desperdiciando espacio, por ejeplo, si es rp = 2.
		
	Hashing Puro
		Dos elementos diferentes del dominio estructurante pueden ser asignados a una misma dirección del espacio de almacenamiento.
		•  𝑋1 ≠ 𝑋2 ⇒ f(𝑋1) = f(𝑋2)
		
		Colisión y Overflow (desborde)
			• En las funciones de hashing puro no está garantizado que la función envíe cada elemento
				a una dirección diferente: dos claves diferentes pueden tener el mismo resultado en su función
				de hash (SINÓNIMOS) produciendo una colisión en ese balde.
			• Overflow o Desborde: Situación en la que un registro es asignado a una dirección (balde) que
			 no tiene suficiente espacio para ser almacenado.
	
	Estrategias para el overflow: Técnicas abiertas o dinámicas
		▪ Se buscan estructuras dinámicas.
		▪ El espacio de almacenamiento se expande o reduce a partir de las bajas y altas de los datos.
		▪ Veremos dos técnicas:
			• El espacio físico primario (array) se mantiene fijo
				◦ Hashing Separado (o con encadenamiento)
					Se crea una lista de ranuras asociada a cada balde de la estructura primaria para manejar el overflow (balde lógico). 
					Estructura secundaria dinámica (listas de reblase) Ranuras secundarias rs = 2, puede ser rp ≠ rs	
					Estructura primaria estática Ranuras primarias rp = 2.
					El problema de esto es que pueden crecer mucho esas listas y la búsquedas se estarían alejando de o(1) por tener que recorrer una larga lista.

			• El espacio físico primario se modifica
				◦ Hashing Separado con Crecimiento
					Estructura secundaria dinámica, rs ranuras secundarias
					Estructura primaria dinámica, rp ranuras por balde primario
					Se pretende que las listas vinculadas a cada balde físico (primario) no crezcan demasiado una respecto a otras

Hashing Separado con Crecimiento				
	• Si hay colisiones se agregan elementos con un criterio de hashing separado.
	• La estructura primaria se podrá expandir y contraer dinámicamente.
		Cuando la estructura primaria crece, se reorganizan todos los elementos en la tabla de hashing (operación costosa), 
		el efecto buscado es que decrezca la longitud de las listas de rebalse (bajando así el costo de acceso).
	• El crecimiento de la estructura primaria no se da continuamente, sino	cuando se cumple cierta condición. 
		Esa condición evalúa cómo es la cantidad de elementos actual respecto al tamaño de la estructura primaria.
	•Se define el un factor de carga de diseño preestablecido (ρd).
	•Como ya vimos, un factor de carga es una relación entre la cantidad elementos que tiene la estructura y la capacidad 
		de la misma (teniendo en cuenta la tabla primaria solamente).
	• La estructura primaria dinámica tendrá M baldes inicialmente (array de M baldes)
	• Se calcula el límite de crecimiento L, a partir del cual la estructura primaria debe crecer. 
		Cuando la cantidad de elementos en la estructura sea mayor o igual a L, la estructura debe crecer (cambia M). 
		Se calcula L como:
			L = | M * rp * ρd |
	• ¿Cómo crece la estructura? dependerá de la implementación (de a un balde, de a muchos, duplicando tamaño, etc). 
		El valor de M cambia entonces L también se recalcula. Hay que reubicar todos los elementos !!
		
	Supongamos una tabla de M=12 y rp=1, y definimos un ρd = 0,5
		Entonces L= | 12 * 1 * 0,5 | = 6
	Entonces estamos diciendo que cuando la cantidad de elementos >= 6, vamos a hacer crecer la estructura primaria.
		
		ρd = 0,5  significa un 50% de ocupación.
		ρd = 0,75 significa un 75% de ocupación.
		
		Si pd es mayor a una quiere decir que mi estrucura se va a llenar y mis elementos van a para a mis listas de rebalse.
		
	El valor que se elije para ρd mantiene un equilibrio entre longitud de listas de rebalse vs espacio que se desperdicia.
		Un valor grande provocará que la estructura se llene demasiado y probablemente haya más colisiones y listas de rebalse más largas.
		Un valor muy bajo mantendrá baja la relación entre elementos en la estructura respecto al tamaño de la misma, o sea un mayor desperdicio de espacio.
					
Técnicas abiertas o dinámicas: JAVA HASHTABLE
		
	Veamos el caso de la HASHTABLE de Java
		
	Valores por defecto: M=11 y ρd = 0,5
	Siempre tiene rp=1

	Estos valores (M y ρd) pueden setearse vía el constructor.
	Cuando se crea calcula L (threshold).
	
	Como función de hashing usa:
		h(x) = x.hashCode() mod M 
	
	x.hashCode( ) es un método definido en object y el valor que retorna es un número que tiene que ver con la dirección de memoria donde se aloja x.
	Da un valor entero, positivo o negativo. Es el lugar de memoria en donde esta X, x la clave de memoria.
	Esto permite calcular la función de hash sobre x que no son numéricos.
				
	• public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>
	
	• Declara la tabla de hashing como un array de Entry:
		• private transient Entry<?,?>[ ] table;
	
	• La definición de Entry es: (Entry si se quiere puede ser el balde)
		• private static class Entry<K,V> implements Map.Entry<K,V> {
			int hash; //hascode que calculé para la clave, lo guarda
			K key;
			V value;
			Entry<K,V> next; //es una lista vinculada !!
		
		…}				
		
	• Agrega elementos con:
		• public synchronized V put(K key, V value) { … }
			• Calcula el índice mediante key.hashCode( ) mod table.length.
			• Si la clave ya había sido agregada, reemplaza el value con el nuevo y devuelve el anterior en el return. Sino devuelve null.
			• Sino genera un nuevo Entry, y lo agrega al inicio de la lista del balde.	
						
		• Si la cantidad de elementos en la table es >= L, entonces llama a Rehash( ), 
			este método crea una nueva tabla con el doble de tamaño de la anterior más uno, y luego va Entry a Entry de la tabla anterior
			reubicándolos en la tabla nueva (recalcula la función de hash a cada uno para saber su nueva ubicación). 
			Y luego ubica el elemento nuevo en la nueva tabla.			
			
		• Rehash (parte más salientes del código):
		protected void rehash() {
			int oldCapacity = table.length;
			Entry<?,?>[ ] oldMap = table;
			int newCapacity = (oldCapacity << 1) + 1;
			Entry<?,?>[ ] newMap = new Entry<?,?>[newCapacity];
			threshold = (int)(newCapacity * loadFactor;
			table = newMap;
			for (int i = oldCapacity ; i -- > 0 ;) {
				for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
					Entry<K,V> e = old;
					old = old.next;
					int index = (e.hash & 0x7FFFFFFF) % newCapacity;
					e.next = (Entry<K,V>)newMap[index];
					newMap[index] = e;
				}
			}
		}			
					
		• Obtiene el valor asociado a una clave con:
			public synchronized V get(Object key) {
				Entry<?,?> tab[ ] = table;
				int hash = key.hashCode();
				int index = (hash & 0x7FFFFFFF) % tab.length;
				for (Entry<?,?> e = tab[index] ; e != null ; e = e.next) { /// busca en la lista vinculada
					if ((e.hash == hash) && e.key.equals(key)) {
						return (V)e.value;
					}
				}
				return null;
			}
		
		• Busca de forma secuencial el elemento en la lista de Entry correspondiente al balde.
		
	Consideraciones finales:
		• El crecimiento busca reducir la longitud de las listas de rebalse.
		• Agregar un elemento es O(1)
		• Y buscar un elemento puede suponerse en promedio de tiempo constante Ө(1), al igual que el eliminar.
			Esto es en promedio, el peor caso va a depender la longitud de la lista.
		• Puede ser útil y a veces necesario redefinir el método HashCode para los objetos que usaremos como clave. 
			Por ejemplo si usamos Integer, vemos redefine (override) hashCode = int que contiene, e Equals si los int son iguales.
			
			
• Supongamos que definimos una HashTable con tamaño inicial 4 y ρd = 0,9
• Entonces resultará L = | 4 * 0,9 | = 3
• Y queremos agregar las siguientes claves x del tipo Integer:
		 
			X          68 40 47 6  76 95 88 23 90 85 31 71 60 10 46 61 50 92 74 7  97 66 1  56

			x mod 4    0  0  3

			x mod 9    5  4  2  6  4  5  7

			Nº         1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24


			L = | 9 * 0,9| = 8
			

Técnicas abiertas o dinámicas: JAVA HASHMAP
	• Más avanzada que HASTABLE. Tiene algunas diferencias. Es más rápida. No es sincronizable.
	
	• Agrega mejora sobre la lista de rebalse, cuando la cantidad de elementos en la lista supera una cierta cantidad establecida, 
		convierte la lista del balde en un árbol binairo de búsqueda balanceado, llevando asi los tiempos de búsqueda en
		el balde de O(n) a O(log2 n), con n = cantidad elementos del balde. 
		Según esta cantidad tiene una lista vinculada o un arbol, por eso los valores de las búsquedas.
		
HashMap y HashTable son dos estructuras de datos utilizadas en lenguajes de programación como Java para almacenar y recuperar pares clave-valor. 
Aunque comparten algunas similitudes, también existen diferencias importantes entre ellas. 
A continuación, se presentan las principales diferencias entre HashMap y HashTable:
	• Sincronización: 
		HashTable es sincronizado, lo que significa que es seguro para su uso en entornos multihilo sin necesidad de tomar medidas adicionales. 
		Múltiples hilos pueden acceder y modificar un objeto HashTable de manera concurrente sin causar problemas de concurrencia. Por otro lado, HashMap no es sincronizado 
		y no garantiza la seguridad en entornos multihilo sin la implementación de mecanismos externos de sincronización.

	• Eficiencia: 
		HashMap es generalmente más eficiente en cuanto a rendimiento que HashTable. Esto se debe a que HashMap no tiene el sobrecosto de sincronización 
		asociado con HashTable. Si no se necesita sincronización, se recomienda utilizar HashMap debido a su mejor rendimiento.

	• Valores nulos: 
		HashMap permite la inserción de valores nulos tanto para las claves como para los valores asociados. En cambio, HashTable no permite la inserción 
		de claves o valores nulos. Si se intenta insertar un valor nulo en un objeto HashTable, se lanzará una excepción NullPointerException.

	• Iteradores: 
		HashMap proporciona iteradores fail-fast, lo que significa que si se modifica el mapa mientras se itera sobre él (excepto a través de los métodos 
		del propio iterador), se lanzará una excepción ConcurrentModificationException. HashTable, por otro lado, no proporciona iteradores fail-fast.

	• Legado: 
		HashTable es una clase más antigua y se considera una estructura de datos legada. Fue parte de la biblioteca original de Java antes de que se 
		introdujera HashMap en la versión 1.2 de Java. HashMap fue diseñado para reemplazar HashTable y se considera la opción preferida en la mayoría de los casos.

En resumen, las principales diferencias entre HashMap y HashTable se relacionan con la sincronización, el rendimiento, la manipulación de valores nulos, 
el comportamiento de los iteradores y su legado. HashMap ofrece un mejor rendimiento, permite valores nulos y no está sincronizado, mientras que HashTable es sincronizado, 
no permite valores nulos y es considerado una opción legada en comparación con HashMap.

		

En general, en una estructura de datos ¿qué hacer si hay claves repetidas?
	• En cualquier estructura de datos podemos distinguir las siguientes situaciones:
	
		• Caso 1: La clave de busqueda coincide con algun identificador (clave) de la información almacenada.
			Quiere decir que para cada valor de clave de búsqueda se corresponde con un único registro de datos asociados.
			Por ejemplo una tabla de hashing para datos de personas, con clave de búsqueda = DNI. 
			Dado un DNI éste identifica a una única persona.

			¿Qué otra clave se le ocurre si hablamos de alumnos de la Facultad?
			La libreta universitaria, LU.
			
		• Caso 2: La clave de busqueda no coincide con algun identificador de la información almacenada.
			Quiere decir que para cada valor posible de clave de búsqueda puedo tener uno o más registros de datos asociados. 
			Esto es un problema …
			Por ejemplo archivo disperso de personas, con clave de búsqueda = Ciudad de Nacimiento. 
			Para cada ciudad de nacimiento vamos a tener una o más personas que nacieron en esa ciudad. 
			Por ejemplo cave de búsqueda=“Tandil”.
			Dado que no es eficiente almacenar claves repetidas, la estrategia que se utiliza es la llamada lista de factoreo.

			Entry para x=Tandil: Tandil , 
				PunteroListaFactoreo
					Datos Persona1 de Tandil
					Datos Persona2 de Tandil
					Datos Persona3 de Tandil
											La lista de factoreo
													contendrá los datos de las distintas personas nacidas en Tandil.
					
					
					
					
					
					
					
					
					
					
					