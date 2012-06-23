package modelo.obstaculos;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.objeto.ObjetoVisible;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.danio.*;

public abstract class Obstaculo implements Daniable, Coordenable,
		ObjetoPosicionable,ObjetoVisible {
	Coordenada cordenadaObsaculo;
	int vida;
	protected int puntaje;

	public Obstaculo(int vidaTotal, Coordenada unacoordenada) {
		this.vida = vidaTotal;
		this.cordenadaObsaculo = unacoordenada.copiar();
		this.puntaje = ConstantesJuego.puntaje_obstaculo_destruido;
	}

	public Coordenada obtenerCoordenadaXY() {
		return cordenadaObsaculo.copiar();
	}

	private void QuitarVida(int danio) {
		if ((vida > 0) && (danio > 0)) {
			vida = vida - danio;
		}
	}

	public boolean Destruido() {
		return (vida <= 0);
	}

	public int vidaRestante() {
		return vida;
	}

	public void Daniar(int danio) {
		if (!this.Destruido()) {
			this.QuitarVida(danio);
		}

	}

	public int obtenerPuntaje() {
		int puntajeAux = 0;
		if (this.Destruido()) {
			puntajeAux = this.puntaje;
		}
		return puntajeAux;
	}

	public int getX() {
		return this.cordenadaObsaculo.obtenerCoordenadaX();
	}

	public int getY() {
		return this.cordenadaObsaculo.obtenerCoordenadaY();
	}

}
