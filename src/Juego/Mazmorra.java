package Juego;

import java.util.Random;
import java.util.Scanner;

public class Mazmorra {
	private Zona zonas[];
	private String dificultad;
	Scanner teclado;

	public Mazmorra(int tamaño) {
		if (tamaño == 1) {
			zonas = new Zona[5];
			dificultad = "Facil";
		}

		if (tamaño == 2) {
			zonas = new Zona[10];
			dificultad = "Normal";
		}

		if (tamaño == 3) {
			zonas = new Zona[15];
			dificultad = "Dificil";
		}

		for (int i = 0; i < zonas.length; i++) {
			Random generador = new Random();
			int numero = generador.nextInt(100);
			
			if (numero <= 60) {
				zonas[i] = new Zona(new Enemigo("Murcielago Gigante", 250, 100, 400, 40));
			}

			if ((numero > 60) && numero <= 80) {
				zonas[i] = new Zona(new Enemigo("Quimera", 500, 250, 900, 70));
			}

			if (numero > 80) {
				zonas[i] = new Zona();
			}
		}
	}

	public void iniciarJuego(Caballero caballero) {
		teclado = new Scanner(System.in);
		while (caballero.estaVivo()) {
			Enemigo tipo;

			for (int i = 0; i < zonas.length; i++) {
				tipo = zonas[i].getEnemigo();
				
				if (tipo == null)
					System.out.println("Esta Zona Estuvo Libre De Enemigo");

				else {
					System.out.println("\nNombre Del Enemigo: "+ tipo.getNombre());
					System.out.println("\nQuiere Evitar Al Enemigo \n1) Escabullirse \n2) Atacar");
					int respuesta = teclado.nextInt();

					if (respuesta == 1) {
						Random generador = new Random();
						int aleatorio = generador.nextInt(100);

						if (aleatorio < 40) {
							System.out.println("\nEl Caballero Burlo Exitosamente Al Enemigo Y Siguio A La Siguiente Zona");
							continue;
						} 
						else {
							Simulador batalla = new Simulador();
							System.out.println("\nNo Pudo Burlar Al Enemigo");
							batalla.simularBatallaEnDesventaja(caballero, tipo);
							batalla.estado(caballero);
						}
					}

					if (respuesta == 2) {
						Simulador batalla = new Simulador();
						batalla.simularBatalla(caballero, tipo);
						batalla.estado(caballero);
					}
				}
			}

			if (caballero.estaVivo()) {
				System.out.println("El Caballero Completo La Mazmorra "+ dificultad + " Con "+ caballero.getPuntosDeVidaActual()+ " Puntos De Vida");
				System.out.println(" >>>> Fin Del Juego <<<< ");
				break;
			} 
			else {
				System.out.println("El Caballero Fue Derrotado En La Mazmorra "+ dificultad);
				System.out.println(" >>>> Fin Del Juego <<<< ");
				break;
			}
		}
	}
}
