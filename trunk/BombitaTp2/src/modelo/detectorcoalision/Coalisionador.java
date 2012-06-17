package modelo.detectorcoalision;
import java.util.Iterator;
import java.util.List;

import modelo.personaje.Personaje;

public class Coalisionador {
	/**********************************************************
	 *La Super Colisionadora de PERSONAJES ESTA VIVOOOOO!!!!***
	 *														***
	 * 														***
	 * 														***
	 * 														***
	 * 														***
	 **********************************************************/

	public void Colicionar(List<Personaje> personajes) {
		if(personajes.size() > 1){// Si tengo mas de un personaje chequeo coliciones.
			Iterator <Personaje>iter = personajes.iterator();
			Personaje pers;
			while(iter.hasNext()){
				pers = iter.next();
				pers.Chocar();
			}
		}
	}
	
}
