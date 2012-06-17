package modelo.articulo;

import modelo.coordenadas.Coordenada;
import modelo.personaje.Bombita;

public abstract class Articulo implements Articulable {

	/*se modifica el estado del personaje pasado por parametro.
	 * de acuerdo al articulo que sea.
	 */
	protected Coordenada coordenadaXY;
	
	public Articulo(Coordenada unaCoordenada){
		coordenadaXY =  unaCoordenada;
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return coordenadaXY;
	}
	
	public abstract void usar(Bombita unPersonaje);
}
