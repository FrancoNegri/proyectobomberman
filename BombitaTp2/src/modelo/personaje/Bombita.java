package modelo.personaje;

import modelo.armamento.*;
import modelo.articulo.*;

public class Bombita extends Personaje {

	
	public Bombita() {
		
		this.velocidad = 5;
		this.vida = 100;
		this.bomba = new Molotov();
		this.coordenadaXY.cambiarCoordenadaX(1);
		this.coordenadaXY.cambiarCoordenadaY(1);
	}
	
	public void tomarArticulo(Articulable unArticulo) {
		unArticulo.usar(this);
	}

	public void cambiarArmamento(Armamento unArmamento) {
		this.bomba = unArmamento;
	}

	public void mover(Personaje unPersonaje) {
	
	}
	
}
