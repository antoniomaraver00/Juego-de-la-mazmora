package Juego;

public class Enemigo {
	private int ataque;
	private int defensa;
	private String nombre;
	private int puntosDeVida;
	private int chancePrimerAtaque;

	public Enemigo(String nombre, int ataque, int defensa, int puntosDeVida, int chancePrimerAtaque) {
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.puntosDeVida = puntosDeVida;
		this.chancePrimerAtaque = chancePrimerAtaque;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public String getNombre() {
		return nombre;
	}

	public int getChancePrimerAtaque() {
		return chancePrimerAtaque;
	}

	public boolean estaVivo() {
		if (puntosDeVida > 0)
			return true;

		return false;
	}

	public void sufrirDaño(int ataqueRecibido) {
		int resultado;
		resultado = ataqueRecibido - defensa;

		if (resultado < 0) {
			puntosDeVida = puntosDeVida;
		} else {
			puntosDeVida = puntosDeVida - resultado;
		}
	}
}
