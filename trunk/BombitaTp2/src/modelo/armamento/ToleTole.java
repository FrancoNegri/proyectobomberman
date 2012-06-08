package modelo.armamento;

import modelo.articulo.Articulable;
import modelo.personaje.*;

public class ToleTole extends Armamento implements Articulable {

	public ToleTole() {
		this.time = 5;
	}
	
	public void usar(Bombita unPersonaje){
		
		unPersonaje.cambiarArmamento(this);
	}
	
}
