package modelo.personaje;


import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionAbajo;
import modelo.Translacion.TranslacionArriba;
import modelo.Translacion.TranslacionDerecha;
import modelo.Translacion.TranslacionIzquierda;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

import java.util.Random;

public abstract class Enemigo extends Personaje {

	protected int puntaje;
	
	public Enemigo(Coordenada unaCoordenada,Mapa nuevoMapa){
		super(unaCoordenada,nuevoMapa);
		this.puntaje = ConstantesJuego.puntaje_enemigo_muerto;
	}
	
	protected void Atacar() {
		if(this.decideAtacar()){
			CreadorDeBombas.crear(this);
		}
	}
	
	public boolean decideAtacar(){
		Random generator = new Random();
		// un 50% de chances de plantar una bomba
		return(generator.nextInt(1000) < 50);
	}

	protected Translacion obtenerTranslacion(){
		Random generator = new Random();
		Translacion translacion [] = {new TranslacionArriba(),new TranslacionAbajo(),new TranslacionDerecha(),new TranslacionIzquierda() }; 
		return translacion[generator.nextInt(4)];
	}
	
	
	public void chocar() {
		this.vida = vida - 1; 
	}
	
	/*public void perseguirABombita(Bombita rodriguez) {
		if (Bombita esta vivo) {
			double distanciaX = Math.abs(rodriguez.obtenerX()-this.obtenerX());
			double distanciaY = Math.abs(rodriguez.obtenerY()-this.obtenerY());
			}
			if (distanciaX > distanciaY) {
				this moverse hacia arriba o hacia abajo (dependiendo de la coordenada de bombita)
				}
				if (distanciaX < distanciaY) {
				this moverse hacia derecha o izquierda (dependiendo de la coordenada de bombita)
				}
					if (distanciaX = distanciaY) {
						this que se mueva para donde quiera
						}

	}*/
	
	public int obtenerPuntaje() {
		int puntajeAux = 0;
		if ( this.estaMuerto() ){
		 puntajeAux = this.puntaje;	
		}
		return puntajeAux;
	}

	@Override
	public void tomarArticulo(Articulable unArticulo) {
		
	}
}
