package ejercicios;

import java.util.Scanner;

import librerias.libreriaMatriz;

public class Ej05 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la matriz 1");
		System.out.println("¿Cuántas filas quieres?");
		int filas1 = teclado.nextInt();
		System.out.println("¿Cuántas columnas quieres?");
		int columnas1 = teclado.nextInt();
		int m1[][] = new int[filas1][columnas1];
		System.out.println("Introduce la matriz.");
		libreriaMatriz.pedirMatriz(m1);
		System.out.println("Tu matriz es:");
		libreriaMatriz.mostrarMatriz(m1);
		
		System.out.println("Introduce la matriz 2");
		System.out.println("¿Cuántas filas quieres?");
		int filas2 = teclado.nextInt();
		System.out.println("¿Cuántas columnas quieres?");
		int columnas2 = teclado.nextInt();
		int m2[][] = new int[filas2][columnas2];
		System.out.println("Introduce la matriz.");
		libreriaMatriz.pedirMatriz(m2);
		System.out.println("Tu matriz es:");
		libreriaMatriz.mostrarMatriz(m2);
	}

}
