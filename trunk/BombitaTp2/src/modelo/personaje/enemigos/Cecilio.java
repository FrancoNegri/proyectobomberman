package modelo.personaje.enemigos;

import modelo.ArmamentoFactory.MolotovFactory;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Enemigo;

public class Cecilio extends Enemigo {

	public Cecilio(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		this.CreadorDeBombas = new MolotovFactory();
		this.vida = ConstantesJuego.vida_lopez_cecilio;
		this.velocidad = ConstantesJuego.velocidad_cecilio;
	}
}
