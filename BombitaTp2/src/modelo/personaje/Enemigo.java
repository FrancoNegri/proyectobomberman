package modelo.personaje;

import modelo.coordenadas.Coordenada;

public class Enemigo extends Personaje {

	public Enemigo(Coordenada unaCoordenada){
		super(unaCoordenada);
	}
	
	public void chocar() {
		this.vida = vida - 1; //Como para que le pase algo al enemigo, igual si choca con alguien es 
							  //con Bombita asique se termina el juego
	}
	
	//public void perseguirABombita(Bombita rodriguez) {
		//Metodo que habria que ver en detalle cuando ya el programa ande asi persigue a bombita. Fede
	//}
}
