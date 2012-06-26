package modelo.personaje;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.*;
import modelo.Translacion.*;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.errores.TamanioMatrizInvalidoError;
import modelo.mapa.Mapa;

public class Bombita extends Personaje {

	
	public Bombita(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		this.velocidad = ConstantesJuego.velocidad_bombita;
		this.vida = ConstantesJuego.velocidad_bombita;
		this.CreadorDeBombas = new MolotovFactory();
	}
	
	public void tomarArticulo(Articulable unArticulo) {
		unArticulo.usar(this);
	}

	
	public void morir() {
		this.vida = 0;
	}
	
	public void chocar() {
		this.morir();
	}

	@Override
	public void Atacar() {
		CreadorDeBombas.crear(this);
	}

	@Override
	protected Translacion obtenerTranslacion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBombita(this);
	}

	@Override
	public Element guardar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void caminar() {
	}
	
	//Movimientos
	public void moverseArriba() {
		Casillero casilleroAlQueMoverse;
		this.ultimaTranslacion = new TranslacionArriba();
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
	
	public void moverseAbajo() {
		Casillero casilleroAlQueMoverse;
		this.ultimaTranslacion = new TranslacionAbajo();
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
	
	public void moverseDerecha() {
		Casillero casilleroAlQueMoverse;
		this.ultimaTranslacion = new TranslacionDerecha();
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
	
	public void moverseIzquierda() {
		Casillero casilleroAlQueMoverse;
		this.ultimaTranslacion = new TranslacionIzquierda();
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
	
}
