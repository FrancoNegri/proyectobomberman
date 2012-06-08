package modelo.articulo;

import modelo.personaje.Bombita;

public class Habano extends Articulo{
	
	public void usar(Bombita unPersonaje){
		
		this.aumentarVelocidad(unPersonaje);
		
	}
	
	public void aumentarVelocidad(Bombita unPersonaje){
		
		float velocidad = unPersonaje.getVelocidad();
		//como convencion aumenta la velocidad del personaje en 10 unidades.
		velocidad+=10;
		unPersonaje.cambiarVelocidad(velocidad);
	}

}
