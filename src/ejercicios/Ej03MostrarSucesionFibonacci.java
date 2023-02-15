package ejercicios;

import funciones.LibreriaFunciones;

public class Ej03MostrarSucesionFibonacci {

	public static void main(String[] args) {
//		 Crear un algoritmo que muestre los primeros 10 números de la 
//		 sucesión de Fibonacci. La sucesión comienza con los números 0 y 1 y, 
//		 a partir de éstos, cada elemento es la suma de los dos números 
//		 anteriores en la secuencia: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55…
		int vectorFibo[];
		int longitud = 10;
		
		vectorFibo = new int [longitud];
		vectorFibo[0]=0;
		vectorFibo[1]=1;
		
		for (int i = 2; i < longitud; i++) {
			vectorFibo[i] = vectorFibo[i-2] + vectorFibo[i-1];
		}
		System.out.println("Las diez primeras posiciones de la sucesión de Fibonacci es:");
		LibreriaFunciones.mostrarVector(vectorFibo);
	}

}
