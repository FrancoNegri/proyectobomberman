package modelo.personaje.enemigos;

import modelo.armamento.Proyectil;
import modelo.personaje.Enemigo;

public class Comun extends Enemigo {
	
	public Comun() {
		this.bomba = new Proyectil();
		this.velocidad = 10;
	}

}
