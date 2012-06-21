package modelo.articulo;

import modelo.coordenadas.Coordenada;
import modelo.personaje.*;

public interface Articulable {

	/*como solo bombita puede utilizar los articulos, se utiliza el metodo esBombita que lo verifica.
	 * lo implemente asi para facilitar el metodo actualizar del casillero.
	 * en el caso que el Personaje sea un enemigo no hace nada.
	 * devuelve true si se uso el articulo.
	 */
	
	public void usar(Personaje unPersonaje);
	
	
	public Coordenada obtenerCoordenadaXY();
	
	public int obtenerPuntaje();
}
