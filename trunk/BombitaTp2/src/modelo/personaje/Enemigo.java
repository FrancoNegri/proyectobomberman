package modelo.personaje;

import modelo.coordenadas.Coordenada;

public class Enemigo extends Personaje {

	public Enemigo(Coordenada unaCoordenada){
		super(unaCoordenada);//Llama al inisializador de personaje
	}
	
	public void chocarCon(Bombita rodriguez) {
		rodriguez.morir();
	}
	
	//public void perseguirABombita(Bombita rodriguez) {
		//Metodo que habria que ver en detalle cuando ya el programa ande asi persigue a bombita. Fede
	//}
}
