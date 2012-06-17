package modelo.personaje.enemigos;

import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Enemigo;

public class Comun extends Enemigo {
	public Comun(Coordenada unaCoordenada) {
		super(unaCoordenada);
		this.bomba = new Proyectil();
		this.velocidad = 10;
	}
}
