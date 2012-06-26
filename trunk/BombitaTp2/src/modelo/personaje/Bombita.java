package modelo.personaje;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.*;
import modelo.Translacion.*;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
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
		this.ultimaTranslacion = new TranslacionArriba();
		this.coordenadaXY = ultimaTranslacion.accion(this.obtenerCoordenadaXY());
	}
	
	public void moverseAbajo() {
		this.ultimaTranslacion = new TranslacionAbajo();
		this.coordenadaXY = ultimaTranslacion.accion(this.obtenerCoordenadaXY());
	}
	
	public void moverseDerecha() {
		this.ultimaTranslacion = new TranslacionDerecha();
		this.coordenadaXY = ultimaTranslacion.accion(this.obtenerCoordenadaXY());
	}
	
	public void moverseIzquierda() {
		this.ultimaTranslacion = new TranslacionIzquierda();
		this.coordenadaXY = ultimaTranslacion.accion(this.obtenerCoordenadaXY());
	}
	
}
