package Juego;

import java.util.Random;

public class Caballero {
	private int ataque;
	private int defensa;
	private int puntosDeVidaTotal;
	private int puntosDeVidaActual;

	public Caballero() {
		Random generador = new Random();
		this.ataque = 200 + generador.nextInt(200);
		this.defensa = 150 + generador.nextInt(150);
		this.puntosDeVidaActual = 800 + generador.nextInt(100);
		this.puntosDeVidaTotal = puntosDeVidaActual;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getPuntosDeVidaTotal() {
		return puntosDeVidaTotal;
	}

	public int getPuntosDeVidaActual() {
		return puntosDeVidaActual;
	}

	public boolean estaVivo() {
		if (puntosDeVidaTotal > 0)
			return true;

		return false;
	}

	public int recuperarVida() {
		if (puntosDeVidaActual + 200 > puntosDeVidaTotal)
			puntosDeVidaActual = puntosDeVidaTotal;

		return puntosDeVidaActual;
	}

	public void sufrirDaño(int ataqueRecibido) {
		int resultado;
		resultado = ataqueRecibido - defensa;

		if (resultado < 0) {
			puntosDeVidaActual = puntosDeVidaActual;
		} else {
			puntosDeVidaActual = puntosDeVidaActual - resultado;
		}
	}
}
