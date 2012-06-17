package modelo.personaje.enemigos;

import modelo.armamento.Molotov;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Enemigo;

public class Cecilio extends Enemigo {

	public Cecilio(Coordenada unaCoordenada) {
		super(unaCoordenada);
		this.bomba = new Molotov();
		
	}
}
