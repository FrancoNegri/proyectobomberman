package modelo.detectorcolision;
import java.util.Iterator;
import java.util.List;

import modelo.personaje.Personaje;

public class Colisionador {
	/**********************************************************
	 *La Super Colisionadora de PERSONAJES ESTA VIVAAAAA!!!!***
	 *														***
	 *......(\_/)                                           ***
	 *......( '_')                                          ***
	 *..../""""""""""""\======()                            ***
	 *./"""""""""""""""""""\                                ***
	 *.\_@_@_@_@_@_@_@_@_@_/                                ***
	**********************************************************/

	public Colisionador() {
		
	}

	public void Colicionar(List<Personaje> personajes) {
		if(personajes.size() > 1){// Si tengo mas de un personaje chequeo coliciones.
			Iterator <Personaje>iter = personajes.iterator();
			Personaje pers;
			while(iter.hasNext()){
				//por polimorfismo sabe que hacer
				pers = iter.next();
				pers.chocar();
			}
		}
	}
	
}
