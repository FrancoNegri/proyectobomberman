package modelo.articulo;


import org.dom4j.Element;

import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.personaje.*;

public abstract class Articulo implements Articulable {

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
		return this.puntaje;
	}
	
	public int getX() {
		return this.coordenadaXY.obtenerCoordenadaX();
	}

	public int getY() {
		return this.coordenadaXY.obtenerCoordenadaY();
	}
	
	public Element guardar(Element elemObstaculo) {
		elemObstaculo.add(coordenadaXY.guardar());
		return elemObstaculo;
	}
}
