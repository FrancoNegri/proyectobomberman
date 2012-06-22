package modelo.articulo;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
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
		this.coordenadaXY =  unaCoordenada.copiar();
		this.puntaje = ConstantesJuego.puntaje_articulos;
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return coordenadaXY.copiar();
	}
	
	public abstract void usar(Personaje unPersonaje);
	


	public int obtenerPuntaje() {
		return puntaje;
	}
	
	public int getX() {
		return this.coordenadaXY.obtenerCoordenadaX();
	}

	public int getY() {
		return this.coordenadaXY.obtenerCoordenadaY();
	}
}
