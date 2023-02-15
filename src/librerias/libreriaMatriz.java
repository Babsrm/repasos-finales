package librerias;

import java.util.Scanner;

import excepciones.MatricesDistintasException;

public class libreriaMatriz {

	public static void pedirMatriz(int matriz[][]) {
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.printf("Introduce el elemento (%d,%d)", i, j);
				matriz[i][j] = teclado.nextInt();
			}
		}
	}
	
	public static void pedirMatriz(double matriz[][]) {
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.printf("Introduce el elemento (%d,%d)", i, j);
				matriz[i][j] = teclado.nextInt();
			}
		}
	}

	public static void mostrarMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println(); // salto de línea
		}
	}
	
	public static void mostrarMatriz(double matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.printf("%.2f ",matriz[i][j]);
			}
			System.out.println(); // salto de línea
		}
	}

	public static void pedirMatrizValorA(int matriz[][], int a) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = a;
			}
		}
	}

	public static boolean comprobarMatrizNula(int matriz[][]) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int contarNumerosEnElementos (double matriz[][], double a) {
		int contador = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == a) {
					contador++;
				}
			}
		}return contador;
	} 
	
	public static boolean comprobarTriangularSuperior (double matriz[][]) {
		if (matriz.length != matriz[0].length
				||	matriz == null
				||	matriz.length<=1) {
			return false;}
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length - i; j++) {
				if (matriz[i][j] == 0) {
					return true;
				}
			} //siempre está por debajo de la diagonal (1,1), (2,2), (3,3)...
		}
		return false;
	}
	
	public static boolean comprobarTriangularInferior (double matriz[][]) {
		if (matriz.length != matriz[0].length
				||	matriz == null
				||	matriz.length<=1) {
			return false;}
		for (int i = 0; i < matriz.length -1; i++) {
			for (int j = i + 1; j <matriz[0].length ; j++) {
				if (matriz[i][j] == 0) {
					return true;
				}
			} //los ceros siempre están por encima de la diagonal
		}
		return false;
	}
	
	public static int valorMaximoEnMatriz (int matriz[][]) {
		int aux = matriz[0][0]; // tb se puede incializar con el menor valor posible: aux = Math.minInteger()
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (aux < matriz[i][j]) {
					aux = matriz[i][j];
				}
			} 
		}return aux;
	}
	
	public static double mediaAritmeticaElementos (double matriz[][]) {
		double totalElems = 0;
		double sumaElems = 0;
		double media;
		for (int i = 0; i < matriz.length; i++) {   
			for (int j = 0; j < matriz[0].length; j++) {
				totalElems++;
				sumaElems = sumaElems + matriz[i][j];		
			}
		} media = sumaElems/totalElems;  // sumaElems/(matriz.length * matriz[0].length)
		return media;
	}
	
	public static double[] vectorMediasColumnas (int matriz[][]) {
		double vector[];
		vector = new double [matriz[0].length];
		double dividendo = 0;
		double aux = 0;
		//la media aritmetica se calcula calculando las medias por columnas, dando como resultado un vector
		//recorro la matriz por columnas
		for (int j = 0; j < matriz[0].length; j++) {
			for (int i = 0; i < matriz.length; i++) {

				dividendo = dividendo + matriz[i][j];
			}
			aux = dividendo/matriz.length;
			vector[j] = aux;
			dividendo=0; //reseteo el valor para que no se acumule en el siguiente bucle
		}
		return vector;
	}
	
	public static double[] vectorMediasFilas (int matriz[][]) {
		double vector[];
		vector = new double [matriz[0].length];
		double dividendo = 0;
		double aux = 0;
		//esta media es calculada por la media de las filas, dando como resultado un vector
		//recorro la matriz por columnas
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0;  j< matriz[0].length; j++) {

				dividendo = dividendo + matriz[i][j];
			}
			aux = dividendo/matriz[0].length;
			vector[i] = aux;
			dividendo=0; //reseteo el valor para que no se acumule en el siguiente bucle
		}
		return vector;
	}
	
	public static double [][] convertirATraspuesta (double matriz[][]) {
		double traspuesta[][];
		traspuesta = new double [matriz[0].length][matriz.length];
		//recorro la matriz original y cambio los índices en la traspuesta
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				 traspuesta[j][i] = matriz[i][j];
			}
		}return traspuesta;
	}
	
	public static double [][] multiplicacionMatrices (double matriz1[][], double matriz2[][], int filas1, int columnas2) {
		double matrizMultiplicada [][];
		matrizMultiplicada = new double [filas1][columnas2];
		
		for (int i = 0; i < filas1; i++) {
			for (int j = 0; j < columnas2; j++) {
				matrizMultiplicada[i][j]=0; //reseteo el valor cada vez que cambia de casilla
				for (int k = 0; k < matriz2.length; k++) { //para que coja el valor correcto de la multiplicación
					matrizMultiplicada[i][j] =matrizMultiplicada[i][j]+ (matriz1[i][k]*matriz2[k][j]);
				}				
			}			
		}return matrizMultiplicada;
	}
	
	public static int cuantosImpares (int matriz[][]) {
		int contador = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j]%2 != 0 )
					contador++;
			}
		} return contador;
	}
	
	public static boolean esDispersa (int matriz[][]) {
		boolean hayCero;
		
		for (int i = 0; i < matriz.length; i++) {
			hayCero = false;  //en cada vuelta lo inicializo en falso, lo reseteo para volver a comprobar que en cada fila hay algún cero
			for (int j = 0; j < matriz[0].length; j++) { //compruebo primero las filas
				if (matriz[i][j] == 0) {
					hayCero = true;
					break; //uso este break para salir y continuar con la función. una vez tenga un cero no hace falta seguir comprobando ni recorriendo más.
				}
			}
			if (!hayCero) {
			return false; //si no ha entrado nunca por aquí, continúa el recorrido a la siguiente
		} 
		}
		
		for (int i = 0; i < matriz.length; i++) {
			hayCero = false;  //en cada vuelta lo inicializo en falso, lo reseteo para volver a comprobar que en cada fila hay algún cero
			for (int j = 0; j < matriz[0].length; j++) { //le digo que recorra mientras la longitud y mientras que hayCero==false porque en el momento en el que es true, se puede salir del bucle y continuar. es escribir la salida del bucle de antes de otra manera que no sea el break
				if (matriz[i][j] == 0) {//compruebo ahora si hay ceros en las columnas
					hayCero = true;
				}
			}
			if (!hayCero) {
			return false; //si tampoco ha entrado por aquí, devolverá el siguiente true, diciéndonos que sí, que es dispersa
		} 
		}
		return true;
	}
	
	public static boolean esSimetrica (double matriz[][]) {
		boolean simetrica = true;
		
		if (matriz.length != matriz[0].length) {
			return false;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] != matriz[j][i]) {
					return false;
				}
			}	
		}return simetrica;
	}
	
	public static int [][] sumarMatrices (int m1[][], int m2[][]) throws MatricesDistintasException {
		if (m1.length != m2.length 
				|| m1[0].length != m2[0].length) {
			throw new MatricesDistintasException();
		}
		
		int m3[][] = new int [m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				
			}
		} return m3;
	}
}
