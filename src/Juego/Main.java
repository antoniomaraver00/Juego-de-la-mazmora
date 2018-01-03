package Juego;

import java.util.Scanner;

public class Main {

	private static int tamaño;
	private static Scanner teclado;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		teclado = new Scanner(System.in);
		int opcion;
		int contador = 1;
		Caballero caballero = new Caballero();
	
		System.out.println("Bienvenido Al Juego De La Mazmorra");
		System.out.println("Tendra 3 intentos para definir los parametros del Caballero ");
		do
		{
			Caballero c = new Caballero();
			System.out.println("Intento Numero "+contador);
			System.out.println("Ataque: "+c.getAtaque());
			System.out.println("Defensa: "+c.getDefensa());
			System.out.println("Puntos De Vida: "+c.getPuntosDeVidaActual());
			System.out.println("Desea comenzar con estos parametros? \n1) Si \n2) No");
			opcion = teclado.nextInt();
			contador ++;
		}while(opcion == 2 && contador < 4);
		

		
		
		System.out.println("Creacion De La Mazmorra \n1) Facil \n2) Normal \n3) Dificil ");
		tamaño = teclado.nextInt();
		Mazmorra mazmorra = new Mazmorra(tamaño);
		System.out.println("\nEl Caballero Se Adentro En La Mazmorra");
		mazmorra.iniciarJuego(caballero);
	}

}
