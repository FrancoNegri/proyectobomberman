package modelo.articulo;

import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.personaje.*;

public abstract class Articulo implements Articulable, Coordenable {

	/*se modifica el estado del personaje pasado por parametro.
	 * de acuerdo al articulo que sea.
	 */
	protected Coordenada coordenadaXY;
	protected int puntaje;
	
	public Articulo(Coordenada unaCoordenada){
		this.coordenadaXY =  unaCoordenada;
		this.puntaje = ConstantesJuego.puntaje_articulos;
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return coordenadaXY;
	}
	
	public abstract boolean usar(Personaje unPersonaje);
	
	public boolean esBombita(Personaje unPersonaje){
		
		boolean esBombita = false;
		if ( unPersonaje instanceof Bombita)
			esBombita = true;
		return esBombita;
	}
	
	public int obtenerPuntaje() {
		return puntaje;
	}
}
