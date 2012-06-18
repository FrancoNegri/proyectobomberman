package modelo.personaje;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.coordenadas.Coordenada;
import modelo.personaje.movimiento.Movimiento;
import modelo.danio.*;


public abstract class Personaje implements Daniable {

	protected ArmamentoFactory CreadorDeBombas;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;

	public Personaje(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
		this.velocidad = 100;
		this.vida = 100;     
	} //Esto lo corregiria con algunas constantes que tenga el mapa por ej 
	  //Velocidad.Juego asi todos tienen la misma velocidad al empezar

	public void caminar(Movimiento unMovimiento) {
		//if (casilleroAUnMovimiento.estaLibre()) {
		unMovimiento.mover(this);
		//else { no hace nada }
	}
	
	public Coordenada obtenerCoordenadaXY() {
		return coordenadaXY;
	}
	
	public void cambiarCoordenadaXY(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
	}

	public int obtenerVida() {
		return vida;
	}

	public void restarVida(int danio) {
		this.vida = vida - danio;
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public void cambiarVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	

	public ArmamentoFactory tirarArmamento() {
		return CreadorDeBombas;
	}
	
	public boolean estaMuerto() {
		return (this.vida <= 0);
	}
	
	public void Daniar(int danio){
		if(!this.estaMuerto()){
			this.restarVida(danio);
		}	
		
	}
	
	public abstract void chocar();
	
}
