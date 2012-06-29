package main;

import modelo.casillero.Casillero;
import modelo.personaje.Bombita;

public class BarraEstado {

	private int velocidad;
	private int puntaje;
	private int vida;
	
	public void actualizarBarraEstado(Bombita rodriguez, Casillero casillero) {
		this.velocidad = rodriguez.getVelocidad();
		this.vida = rodriguez.obtenerVida();
		this.puntaje = casillero.obtenerPuntaje();
		this.dibujarEstadoPuntaje();
		this.dibujarEstadoVelocidad();
		this.dibujarEstadoVida();
	}
	
	public void dibujarEstadoPuntaje() {
		//Dibujar el label en la ventana
	}

	public void dibujarEstadoVida() {
		//Dibujar el label en la ventana
	}
	
	public void dibujarEstadoVelocidad() {
		//Dibujar el label en la ventana
	}

	public int getVelocidadBarraEstado() {
		return velocidad;
	}

	public void cambiarVelocidadBarraEstado(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPuntajeBarraEstado() {
		return puntaje;
	}

	public void setPuntajeBarraEstado(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getVidaBarraEstado() {
		return vida;
	}

	public void setVidaBarraEstado(int vida) {
		this.vida = vida;
	}
	
	
}
