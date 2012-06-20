package modelo.personaje;


import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionAbajo;
import modelo.Translacion.TranslacionArriba;
import modelo.Translacion.TranslacionDerecha;
import modelo.Translacion.TranslacionIzquierda;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import java.util.Random;
public class Enemigo extends Personaje {

	public Enemigo(Coordenada unaCoordenada){
		super(unaCoordenada);
	}
	
	protected void Atacar() {
		if(this.decideAtacar()){
			CreadorDeBombas.crear(this);
		}
	}
	
	private boolean decideAtacar(){
		Random generator = new Random();
		// un 50% de chances de plantar una bomba
		return(generator.nextInt(10) < 4);
	}

	protected Translacion obtenerTranslacion(){
		Random generator = new Random();
		Translacion translacion [] = {new TranslacionArriba(),new TranslacionAbajo(),new TranslacionDerecha(),new TranslacionIzquierda() }; 
		return translacion[generator.nextInt(4)];
	}
	
	
	public void chocar() {
		this.vida = vida - 1; //Como para que le pase algo al enemigo, igual si choca con alguien es 
							  //con Bombita asique se termina el juego
	}
	
	//public void perseguirABombita(Bombita rodriguez) {
		//Metodo que habria que ver en detalle cuando ya el programa ande asi persigue a bombita. Fede
	//}
}
