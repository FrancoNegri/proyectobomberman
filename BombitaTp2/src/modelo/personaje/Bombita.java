package modelo.personaje;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

public class Bombita extends Personaje {

	
	public Bombita(Coordenada unaCoordenada) {
		super(unaCoordenada);
		this.velocidad = ConstantesJuego.velocidad_bombita;
		this.vida = ConstantesJuego.velocidad_bombita;
		this.CreadorDeBombas = new MolotovFactory();
	}
	
	public void tomarArticulo(Articulable unArticulo) {
		unArticulo.usar(this);
	}

	public void cambiarArmamento(ArmamentoFactory nuevoCreador) {
		this.CreadorDeBombas = nuevoCreador;
	}
	
	public void morir() {
		this.vida = 0;
	}
	
	public void chocar() {
		this.morir();
	}
	
}
