package modelo.detectorcolision;
import java.util.Iterator;
import java.util.List;

import modelo.personaje.Personaje;

public class Coalisionador {
	/**********************************************************
	 *La Super Colisionadora de PERSONAJES ESTA VIVAAAAA!!!!***
	 *														***
	 *......(\_/)                                           ***
	 *......( '_')                                          ***
	 *..../""""""""""""\======()                            ***
	 *./"""""""""""""""""""\                                ***
	 *.\_@_@_@_@_@_@_@_@_@_/                                ***
	**********************************************************/



	public void Colicionar(List<Personaje> personajes) {
		if(personajes.size() > 1){// Si tengo mas de un personaje chequeo coliciones.
			Iterator <Personaje>iter = personajes.iterator();
			Personaje pers;
			while(iter.hasNext()){
				//if (colicionProducida(pers1, pers2) == true) , donde pers2 seria el iter.next(). Fede
				pers = iter.next();
				pers.chocar();
			}
		}
	}
	
}
