package modelo.personaje;

import java.util.LinkedList; 

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.movimiento.*;
import modelo.danio.*;


public abstract class Personaje implements Daniable , Coordenable {

	protected ArmamentoFactory CreadorDeBombas;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;
	protected LinkedList<Movimiento> movimientos;
	protected Movimiento movimiento;
	protected Mapa mapa;
	
	public Personaje(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
		this.movimientos = new LinkedList<Movimiento>();
		this.movimiento = new Movimiento();
		this.movimientos = movimiento.inicializarMovimientos();
	} 

	protected abstract void caminar();
	
	public abstract void actualizar();
	
	public Coordenada obtenerCoordenadaXY() {
		return coordenadaXY;
	}
	
	public void cambiarCoordenadaXY(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
	}

	public void setMapa(Mapa nuevoMapa){
		mapa = nuevoMapa;
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
	
	
	public LinkedList<Movimiento> obtenerMovimientos() {
		return movimientos;
	}
	
	public Movimiento obtenerDireccionDeMovimiento() {
		int posicion = movimiento.obtenerNumeroRandom();
		return movimientos.get(posicion-1);
	}
	
	public Movimiento getUltimoMovimiento(){
		return this.movimiento;	
	}
	
	public void setUltimoMovimiento(Movimiento unMovimiento){
		this.movimiento = unMovimiento;
	}
	
	public Casillero verificarA(Movimiento unMovimiento,Mapa mapa){
		Coordenada coord;
		Personaje aux;
		aux = this;
		unMovimiento.mover(aux);
		coord = aux.obtenerCoordenadaXY();
		return (mapa.obtenerCasillero(coord));	
		
	}
}
