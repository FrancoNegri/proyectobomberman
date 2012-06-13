package modelo.personaje;

import modelo.armamento.Armamento;
import modelo.coordenadas.Coordenada;
import modelo.personaje.movimiento.Movimiento;


public abstract class Personaje implements Caminable {

	protected Armamento bomba;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;

	public Personaje() {
		this.coordenadaXY = new Coordenada();
	}

	public void tirarBomba() {
		//agregar la bomba en el casillero
	}

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
}
