package modelo.personaje;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.movimiento.*;
import modelo.puntaje.Punteable;
import modelo.danio.*;

public abstract class Personaje implements Daniable, Coordenable, Punteable {
	protected Translacion ultimaTranslacion;
	protected ArmamentoFactory CreadorDeBombas;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;
	protected Mapa mapa;

	public Personaje(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
		ultimaTranslacion = new TranslacionDerecha();
	}

	protected abstract Translacion obtenerTranslacion();

	public abstract void chocar();

	protected abstract void Atacar();

	public Coordenada obtenerCoordenadaXY() {
		return coordenadaXY;
	}

	public void cambiarCoordenadaXY(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
	}

	public Translacion obtenerUltimaTranslacion() {
		return ultimaTranslacion;
	}

	public void setMapa(Mapa nuevoMapa) {
		mapa = nuevoMapa;
	}

	public Mapa getMapa() {
		return mapa;
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

	public void Daniar(int danio) {
		if (!this.estaMuerto()) {
			this.restarVida(danio);
		}

	}

	public void actualizar() {
		this.caminar();
		this.Atacar();
	}

	protected void caminar() {
		Translacion translasionRandom = this.obtenerTranslacion();
		Coordenada movimientoPlaneado = translasionRandom.accion(coordenadaXY);
		Casillero casilleroAlQueMoverse = mapa
				.obtenerCasillero(movimientoPlaneado);
		if (casilleroAlQueMoverse.esCaminable()) {
			Casillero casilleroAntiguo = mapa.obtenerCasillero(coordenadaXY);
			casilleroAntiguo.eliminar(this);
			coordenadaXY = movimientoPlaneado;
			mapa.agregarAlMapa(this);
		}
	}

	public Casillero verificarA(Movimiento unMovimiento, Mapa mapa) {
		Coordenada coord;
		Personaje aux;
		aux = this;
		unMovimiento.mover(aux);
		coord = aux.obtenerCoordenadaXY();
		return (mapa.obtenerCasillero(coord));

	}
}
