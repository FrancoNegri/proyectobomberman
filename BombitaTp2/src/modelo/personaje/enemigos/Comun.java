package modelo.personaje.enemigos;

import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Enemigo;

public class Comun extends Enemigo {
	
	public Comun(Coordenada unaCoordenada) {
		super(unaCoordenada);
		CreadorDeBombas = new ProyectilFactory();
		this.velocidad = 200;
	}
}
