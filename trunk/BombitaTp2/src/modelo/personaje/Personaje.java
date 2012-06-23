package modelo.personaje;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import vista.objeto.ObjetoVisible;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.danio.*;
import modelo.errores.TamanioMatrizInvalidoError;

public abstract class Personaje implements ObjetoVisible, Daniable,ObjetoPosicionable , ObjetoVivo {
	protected Translacion ultimaTranslacion;
	protected ArmamentoFactory CreadorDeBombas;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;
	protected Mapa mapa;

	public Personaje(Coordenada unaCoordenada,Mapa nuevoMapa) {
		this.coordenadaXY = unaCoordenada.copiar();
		ultimaTranslacion = new TranslacionDerecha();
		mapa = nuevoMapa;
		mapa.agregarAlMapa(this);
	}

	protected abstract Translacion obtenerTranslacion();

	public abstract void chocar();

	protected abstract void Atacar();
	
	public abstract void tomarArticulo(Articulable unArticulo);

	public Coordenada obtenerCoordenadaXY() {
		return coordenadaXY.copiar();
	}

	public void cambiarCoordenadaXY(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
	}

	public Translacion obtenerUltimaTranslacion() {
		return ultimaTranslacion;
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
	
	public void cambiarArmamento(ArmamentoFactory nuevoCreador) {
		this.CreadorDeBombas = nuevoCreador;
	}

	public boolean estaMuerto() {
		return (this.vida <= 0);
	}

	public void Daniar(int danio) {
		if (!this.estaMuerto()) {
			this.restarVida(danio);
		}

	}

	protected void caminar() {
		Casillero casilleroAlQueMoverse;
		ultimaTranslacion = this.obtenerTranslacion();
		Coordenada movimientoPlaneado = ultimaTranslacion.accion(coordenadaXY);
		try{
		casilleroAlQueMoverse = mapa.obtenerCasillero(movimientoPlaneado);
		}catch(TamanioMatrizInvalidoError e){return;}//Caso que el Personaje intenta salirse del mapa
		if (casilleroAlQueMoverse.esCaminable()){
			Casillero casilleroAntiguo = mapa.obtenerCasillero(coordenadaXY);
			casilleroAntiguo.eliminar(this);
			coordenadaXY = movimientoPlaneado;
			mapa.agregarAlMapa(this);
		}
	}

	
	public void vivir() {
		if(!this.estaMuerto()){
			this.caminar();
			this.Atacar();
		}
	}
	

	public int getX() {
	return this.coordenadaXY.obtenerCoordenadaX();
	}

	public int getY() {
	return this.coordenadaXY.obtenerCoordenadaY();
	}
}


