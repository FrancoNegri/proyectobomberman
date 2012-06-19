package modelo.personaje.enemigos;

import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Enemigo;

public class Comun extends Enemigo {
	
	public Comun(Coordenada unaCoordenada) {
		super(unaCoordenada);
		CreadorDeBombas = new ProyectilFactory();
		this.velocidad = ConstantesJuego.velocidad_lopez_reggae_comun;
		this.vida = ConstantesJuego.vida_lopez_reggae_comun;
	}
}
