package modelo.articulo;

import modelo.personaje.Bombita;

public abstract class Articulo implements Articulable {

	/*se modifica el estado del personaje pasado por parametro.
	 * de acuerdo al articulo que sea.
	 */
	
	public abstract void usar(Bombita unPersonaje);
}
