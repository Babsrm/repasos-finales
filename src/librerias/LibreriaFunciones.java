package librerias;

import java.util.Scanner;

import javax.swing.plaf.FontUIResource;

public class LibreriaFunciones {
	public static void pedirVector(double vector[]) {
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < vector.length; i++) {
			System.out.println("Introduce el elemento " + i);
			vector[i] = teclado.nextDouble();
		}
	}
	// parece la misma funcion de arriba pero esta es para numeros int. es la misma
	// funcion, sí, pero java sabe diferenciar cuál de las dos utilizar cuando la
	// invocamos por el tipo de dato

	public static void pedirVector(int vector[]) {
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < vector.length; i++) {
			System.out.println("Introduce el elemento " + i);
			vector[i] = teclado.nextInt();
		}
	}

	public static void mostrarVector(double vector[]) {
		for (int i = 0; i < vector.length; i++) {
			System.out.printf("%.2f ", vector[i]);
		}
		System.out.println(); // salto de linea, por estética
	}

	public static void mostrarVector(int vector[]) {
		for (int i = 0; i < vector.length; i++) {
			System.out.printf("%d ", vector[i]);
		}
		System.out.println(); // salto de linea, por estética
	}

	public static void mostrarMenorQue(int vector[], int tope) {
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] < tope) {
				System.out.print(vector[i] + " ");
			}
		}
	}

	public static int devolverMenor(int vector[]) {
		int menor = vector[0];
		// int menor = vector[vector.length-1]; con este cogeríamos el último pero es
		// más sencillo empezar por la primera posición
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] < menor) {
				menor = vector[i];
			}
		}
		return menor;
	}

	public static void mostrarIntervalo(double vector[], double a, double b) {
		if (a > b) {
			double aux = b;
			b = a;
			a = aux;
		}
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] >= a && vector[i] < b) {
				System.out.println(vector[i] + " ");
			}

		}
	}

	public static void moverPosicionIzq(int vector[]) {
		int aux = vector[0];
		for (int i = 0; i < vector.length - 1; i++) { // la condicion tiene que ser hasta el penúltimo porque en el último he de poner el primero
			vector[i] = vector[i + 1]; // v[1]=v[2], osea voy moviendo los resultados a la izq, y el[0] que tiene que irse al final, lo guardo en una variable auxiliar y, una vez hecho el bucle, la sustituyo.
		}
		vector[vector.length - 1] = aux; // si la longitud es 5 pero la posición máxima es 4 (porque empezamos por la posición 0); de ahí el restarle 1
	}
	
	public static void moverPosicionIzqConPos(int vector[], int rotacion) {
		for (int i = 0; i < rotacion; i++) { 
			LibreriaFunciones.moverPosicionIzq(vector);
		} //lo que pido es que repita la funcion de mover la posicion a la izquierda tantas veces como el usuario haya indicado con la variable rotacion.
		//no es del todo eficiente porque si el array es muy grande y la rotación también lo es, pecaría. en ese caso, habría que crear una función nueva. Esta forma es el equilibrio entre reutilización de código (funciones) y eficiencia.
	}

	public static void moverPosicionDer(int vector[]) {
		int aux = vector[vector.length - 1];
		for (int i = vector.length - 1; i >= 1; i--) {
			vector[i] = vector[i - 1];
		}
		vector[0] = aux;
	}
	
	public static void moverPosicionDerConPos(int vector[], int rotacion) {
		for (int i = 0; i < rotacion; i++) { 
			LibreriaFunciones.moverPosicionDer(vector);
			}}

	public static void mostrarDesdeValorMayorQueA(int vector[], int a) {
		int i = 0;
		for (i = 0; i < vector.length; i++) {
			if (vector[i] >= a) {
				break; //me salgo del bucle al llegar al número
			}
		}
		for (int j = i; j < vector.length; j++) {
			System.out.printf("%d ", vector[j]);
		} //aqui pinto el array j que empieza desde la posición en la que se encontró el número necesario para salir del bucle
		}
	
	
	public static boolean vectorParalelo(double vector1[], double vector2[]) { //con booleanos
		if (vector1.length != vector2.length) {
			return false; //y se sale directamente de la función. Esto es para comprobar que sean iguales de longitud los arrays. Aunque lo haya preguntado en el ejercicio, es bueno hacer esta comprobación aquí porque obligo a la comprobación aunque la función se haya ejecutado en otros lugares.
		}
			
		boolean sonParalelos= true;
		double factor = vector1[0] / vector2[0]; //es el factor por el que cada divisor tiene que coincidir para ser paralelo
		
		for (int i = 1; i < vector1.length && sonParalelos; i++) { //se repite el bucle mientras sea verdadero que son paralelos y que esté dentro de rango
			if (vector1[i] / vector2[i] != factor
					&&
				(vector1[i] != 0 || vector2[i] != 0) //comprobaciones de divisiones con posibles ceros que tenga
				) {									// el array
			
				sonParalelos = false;
			}
		}
		return sonParalelos;
	}
	
	public static boolean arrayCapicua (int array[]) {
		boolean esCapicua = true;
		
		for (int i = 0, j = array.length -1; i < (array.length/2) && esCapicua; i++, j--) {
			if (array[i] != array[j]) {
				esCapicua = false;
			}
		}
		return esCapicua;
	}
	
	public static int [] arrayInverso (int array[], int longitud) {
		int arrayInverso[] = new int [longitud] ;
		// for (int i=0, j=array.length-1 ; i<array.length; i++, j--) {
		//     arrayInverso[i] = array[j];    --- es lo mismo escrito de otra manera que quizás se entienda mejor
		for (int i = 0; i < longitud; i++) {
			 arrayInverso[longitud-1 -i]= array[i] ;
		}
		return arrayInverso;
	}
	
	public static int [] concatenarArrays (int array1[], int array2[], int longitud1, int longitud2) {
		int arrayConcatenado[] = new int [longitud1 + longitud2];
		for (int i = 0; i < longitud1 ; i++) {
			arrayConcatenado[i] = array1[i];
		}
		for (int j = longitud1; j < arrayConcatenado.length; j++) {
			arrayConcatenado[j] = array2[j - longitud1];
		}
		return arrayConcatenado;
		}
	
	public static int [] sumaArrays (int array1[], int array2[]) {
		if (array1.length != array2.length) {
			System.err.println("Los índices de los arrays son diferentes. El programa se cerrará. ");
			return null;}
		int arraySuma[] = new int [array1.length];
		for (int i = 0; i < arraySuma.length; i++) {
			arraySuma[i] = array1[i] + array2[i];
			}
		return arraySuma;
	} 
	
	public static void ordenarBurbuja (int vector[]) {
		int aux;
		
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector.length -1 -i; j++) {
				if( vector[j] > vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}
		}
	}
	
	public static void ordenarBurbujaMejorado (int vector[]) {
		int aux;
		
		boolean hayCambios = true; //para avisarnos de que ha habido algún cambio de ordenación. Parará el bucle cuando deje de haber cambios en el orden del vector
		
		for (int i = 0; i < vector.length && hayCambios; i++) {
			hayCambios=false;
			for (int j = 0; j < vector.length -1 -i; j++) {
				if( vector[j] > vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
					hayCambios = true;
				}
			}
		}
	}
	
	public static void ordenacionPorSeleccion (int vector[]) {
		int auxMenor;
		int posicionMenor;
		
		for (int i = 0; i < vector.length -1; i++) {
			auxMenor = vector[i];
			posicionMenor = i;
			for (int j =  i +1; j < vector.length; j++) {
				if (vector[j] < auxMenor) {
					auxMenor = vector[j];
					posicionMenor = j;
				}
			}
			vector[posicionMenor] = vector[i];
			vector[i] = auxMenor;
		}
	}
	
	
	}

