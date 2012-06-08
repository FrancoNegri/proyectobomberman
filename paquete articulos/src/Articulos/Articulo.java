package Articulos;

import java.util.*;

import Personajes.Personaje;
//incluir aca el paquete de personaje

public interface Articulo {
	
	/*se modifica el estado del personaje pasado por parametro.
	 * de acuerdo al articulo que sea.
	 */
	
	public void Usar(Personaje unPersonaje);

}
