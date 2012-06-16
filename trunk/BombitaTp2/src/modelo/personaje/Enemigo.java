package modelo.personaje;

public class Enemigo extends Personaje {

	public Enemigo (){
		this.coordenadaXY.cambiarCoordenadaX(0);
		this.coordenadaXY.cambiarCoordenadaY(0);
	}

	public void chocarCon(Bombita rodriguez) {
		rodriguez.morir();
	}
	
	//public void perseguirABombita(Bombita rodriguez) {
		//Metodo que habria que ver en detalle cuando ya el programa ande asi persigue a bombita. Fede
	//}
}
