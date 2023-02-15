package ejercicios;

import java.util.Scanner;

public class Ej01CalculoPrecioMoto {

	public static void main(String[] args) {
//		 Haz un programa que pida el precio de una moto y la marca. Calcula 
//		 el precio final de la moto de la siguiente manera
//		 Las motos marca Honda tienen un descuento del 5%, las marcas 
//		 Yamaha del 8% y las Suzuki del 10%, las otras marcas 2%. Se debe 
//		 mostrar el precio de la moto, el descuento y el precio a pagar.
		
		Scanner teclado = new Scanner(System.in);
		String marca = "";
		double precio = 0;
		double descuento = 0;
		double precioFinal = 0;
		
		System.out.println("Este programa calculará el precio de una motocicleta con descuentos aplicables según baremos. El usuario proporcionará el precio y la marca de la motocicleta. El algoritmo hará el cálculo del descuento y precio final.");
		System.out.println("Introduzca la marca:");
		marca = teclado.nextLine();
		
		try {
			while (marca.isBlank() || marca == null) {
			System.out.println("El valor introducido no es válido o está en blanco.");
			System.out.println("Por favor, introduzca una cadena de caracteres.");
			marca = teclado.nextLine();}
		} catch (Exception e) {
			e.printStackTrace();		
		};
		
		System.out.println("Introduzca el precio:");
		precio = teclado.nextDouble();
		
		try {
		while (precio<=0) {
			System.out.println("El valor introducido no es válido.");
			System.out.println("Introduzca un valor positivo.");
			precio = teclado.nextDouble();	
		} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if (marca.equalsIgnoreCase("honda")) {
			descuento = 0.05;
		} else if (marca.equalsIgnoreCase("yamaha")) {
			descuento = 0.08;
		} else if (marca.equalsIgnoreCase("suzuki")) {
			descuento = 0.1;
		} else {
			descuento = 0.02;
		}
		precioFinal =precio - precio*descuento;
		
		System.out.println("Los datos introducidos son:\n"
				+ "Marca: " +marca.toUpperCase()
				+ "\nPrecio: " +String.format("%.2f",precio) + "€"
				+ "\nDescuento aplicado: " +String.format("%.2f",precio*descuento) +"€"
				+ "\nPrecio final: " +String.format("%.2f",precioFinal) +"€");
		teclado.close();
	}
	}
