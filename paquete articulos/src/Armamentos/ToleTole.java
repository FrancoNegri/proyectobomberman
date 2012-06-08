package Armamentos;

import Articulos.Articulo;

import Personajes.Personaje;

public class ToleTole extends Armamento implements Articulo {
	
	public void Usar(Personaje unPersonaje){
		
		unPersonaje.CambiarArmamento(this);
	}

}
