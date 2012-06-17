package modelo.articulo;

import modelo.coordenadas.Coordenada;
import modelo.personaje.Bombita;

public interface Articulable {

	public void usar(Bombita unPersonaje);
	
	public Coordenada obtenerCoordenadaXY();
}
