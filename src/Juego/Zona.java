package Juego;

public class Zona {
	private Enemigo enemigo;
	
	public Zona(){
		this.enemigo = null;
	}
	
	public Zona(Enemigo enemigo){
		this.enemigo = enemigo;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}
}
