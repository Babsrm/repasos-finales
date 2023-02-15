package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej02CalculoSueldo {

	public static void main(String[] args) {
//		Haz un programa que calcule el sueldo que le corresponde al 
//		trabajador de una empresa que cobra 40.000 euros anuales, el 
//		programa debe realizar los cálculos en función de los siguientes 
//		criterios:
//		a. Si lleva más de 10 años en la empresa se le aplica un aumento 
//		del 10%.
//		b. Si lleva menos de 10 años pero más que 5 se le aplica un 
//		aumento del 7%.
//		c. Si lleva menos de 5 años pero más que 3 se le aplica un aumento 
//		del 5%.
//		d. Si lleva menos de 3 años se le aplica un aumento del 3%.
		
		System.out.println("Este programa calcula el sueldo de un empledado según unos baremos que varían en dependencia de su antigüedad en la empresa.");
		double sueldo = 0;
		int antiguedad = 0;
		double aumento = 0;
		double sueldoFinal = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el sueldo del empleado:");
		try {
			sueldo = teclado.nextDouble();
		}catch (InputMismatchException e) { 
			//si el usuario introduce caracteres en vez de números, fuerzo a que entre en el siguiente try poniendo el sueldo en negativo
			sueldo=-1;
			teclado.nextLine(); //además, borro el buffer de los caracteres introducidos para que sea capaz de seguir ejecutando las líneas de código
		}
		
		try {
			while (sueldo<=0) {
				System.out.println("El valor introducido no es válido.");
				System.out.println("Introduzca un valor numérico positivo.");
				sueldo = teclado.nextDouble();	
			} 
		}catch (InputMismatchException e) { 
				e.printStackTrace();
			}
		System.out.println("Introduzca la antigüedad del empleado, en años:");
		try {
		antiguedad = teclado.nextInt();
		}catch (InputMismatchException e) { 
			//si el usuario introduce caracteres en vez de números, fuerzo a que entre en el siguiente try poniendo el sueldo en negativo
			antiguedad=-1;
			teclado.nextLine(); //además, borro el buffer de los caracteres introducidos para que sea capaz de seguir ejecutando las líneas de código
		}
		
		try {
			while (antiguedad<=0 || antiguedad>45) {
				System.out.println("El valor introducido no es válido.");
				System.out.println("Introduzca un valor numérico positivo entre 0 y 45.");
				antiguedad = teclado.nextInt();	
			} 
		}catch (Exception e) {
				e.printStackTrace();
			}

		if (antiguedad<3) {
			aumento = 0.03;
			System.out.println("Aumento aplicado del 3%");
		} else if (antiguedad<5) {
			aumento = 0.05;
			System.out.println("Aumento aplicado del 5%");
		} else if (antiguedad <10) {
			aumento = 0.07;
			System.out.println("Aumento aplicado del 7%");
		} else {
			aumento = 0.10;
			System.out.println("Aumento aplicado del 10%");
		}
		
		sueldoFinal = sueldo + sueldo*aumento;
		
		System.out.println("Los datos introducidos son:\n"
				+ "Sueldo: " +String.format("%.2f", sueldo) +"€"
				+ "\nAntigüedad: " +antiguedad +" años"
				+ "\nAumento aplicado: " +String.format("%.2f",sueldo*aumento) +"€"
				+ "\nSueldo final: " +String.format("%.2f",sueldoFinal) +"€");
	}

}
