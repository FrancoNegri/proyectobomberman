package Articulos;

import Personajes.Personaje;;

public class Habano implements Articulo{
	
	public void Usar(Personaje unPersonaje){
		
		this.aumentarvelocidad(unPersonaje);
		
	}
	
	public void aumentarvelocidad(Personaje unPersonaje){
		
		int velocidad=unPersonaje.velocidad();
		//como convención aumenta la velocidad del personaje en 10 unidades.
		velocidad+=10;
		unPersonaje.setvelocidad(velocidad);
	}

}
