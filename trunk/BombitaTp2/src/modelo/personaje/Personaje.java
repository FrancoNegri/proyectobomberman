package modelo.personaje;

import modelo.armamento.Armamento;
import modelo.coordenadas.Coordenada;
import modelo.personaje.movimiento.Movimiento;
import modelo.danio.*;


public abstract class Personaje implements Daniable {

	protected Armamento bomba;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;

	public Personaje(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
		velocidad = 100;/*no deverian ser pasados por parametro a el constructor? Franco*/
		vida = 100;     /*no deverian ser pasados por parametro a el constructor?*/
	}/*me parece un harcodeo horrible?*/

	public void caminar(Movimiento unMovimiento){
		unMovimiento.mover(this);
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return coordenadaXY;
	}

	public int getVida() {
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
	
	public Armamento armamentoActual() {
		return bomba;
	}
	
	public boolean estaMuerto() {
		return (this.vida <= 0);
	}
	
	public void Daniar(int danio){
		if(!this.estaMuerto()){
			this.restarVida(danio);
		}	
		
	}

	public void Chocar() {
	}
}
