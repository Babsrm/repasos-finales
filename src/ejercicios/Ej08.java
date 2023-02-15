package ejercicios;

import java.util.Scanner;

import librerias.LibreriaFunciones;
import librerias.libreriaMatriz;

public class Ej08 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Cuántas filas quieres?");
		int filas = teclado.nextInt();
		System.out.println("¿Cuántas columnas quieres?");
		int columnas = teclado.nextInt();
		int m[][] = new int[filas][columnas];
		System.out.println("Introduce la matriz.");
		libreriaMatriz.pedirMatriz(m);
		System.out.println("Tu matriz es:");
		libreriaMatriz.mostrarMatriz(m);		
		
		
		int vector[] = new int [m.length * m[0].length];
		int posicion=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
//				vector[i*m[0.length] +j] = m[i][j];
				vector[posicion] = m[i][j];
				posicion++;
			}
		}
		System.out.println("El vector resultante de la matriz es: ");
		LibreriaFunciones.mostrarVector(vector);
	}
}
