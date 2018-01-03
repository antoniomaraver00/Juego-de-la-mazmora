package Juego;

import java.util.Random;

public class Simulador {

	public void simularBatalla(Caballero caballero, Enemigo enemigo) {
		Random generador = new Random();
		int numero = generador.nextInt(100);

		if (numero < enemigo.getChancePrimerAtaque()) {
			System.out.println("\nEl Enemigo " + enemigo.getNombre()+ " Ataco De Primero");

			while (enemigo.estaVivo() && caballero.estaVivo()) {
				caballero.sufrirDaño(enemigo.getAtaque());

				if (caballero.estaVivo() == false) {
					System.out.println("\nEl Caballero Esta Muerto");
					break;
				}

				else {
					enemigo.sufrirDaño(caballero.getAtaque());
				}
			}
		}

		else {
			if (numero > enemigo.getChancePrimerAtaque()) {
				System.out.println("\nEl Caballero Ataco De Primero");

				while (caballero.estaVivo() && enemigo.estaVivo()) {
					enemigo.sufrirDaño(caballero.getAtaque());

					if (enemigo.estaVivo() == false) {
						System.out.println("El Enemigo " + enemigo.getNombre()+ " Esta Muerto");
						Random generador1 = new Random();
						int numero1 = generador1.nextInt(100);

						if (numero1 < 50) {
							caballero.recuperarVida();
							System.out.println("El Enemigo "+ enemigo.getNombre() + " Dejo Una Pocion");
							System.out.println("El Caballero Recupero 200 Puntos De Vida "+ caballero.getPuntosDeVidaActual());
						}
						break;
					}

					else {
						caballero.sufrirDaño(enemigo.getAtaque());
					}
				}
			}
		}
	}

	public void simularBatallaEnDesventaja(Caballero caballero, Enemigo enemigo) {
		System.out.println("El Enemigo " + enemigo.getNombre()+ " Ataco De Primero");

		while (enemigo.estaVivo() && caballero.estaVivo()) {
			caballero.sufrirDaño(enemigo.getAtaque());

			if (caballero.estaVivo() == false) {
				System.out.println("El Caballero Esta Muerto");
				break;
			}

			else {
				enemigo.sufrirDaño(caballero.getAtaque());
				break;
			}
		}
	}

	public void estado(Caballero caballero) {
		if (caballero.estaVivo()) {
			System.out.println("Victoria Del Caballero En La Batalla ");
			System.out.println("Puntos De Vida: "+ caballero.getPuntosDeVidaActual());
		}

		else {
			System.out.println("El Enemigo Ha Ganado La Batalla");
		}
	}
}
