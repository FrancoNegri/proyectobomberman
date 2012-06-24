package modelo.mapa;

import org.dom4j.Node;

import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.errores.CasilleroOcupadoError;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;



import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.*;
import org.dom4j.io.SAXReader;


public class Mapa implements ObjetoVivo{
	private Tablero TableroJuego;
	int puntajeTotal;
	public Mapa(int tamanio) {
		this.TableroJuego = new Tablero(tamanio);
	}
	
	private void agregarCasillero(Coordenada coord, Casillero unCasillero) {
		this.TableroJuego.cambiarCasillero(coord, unCasillero);
	}

	private void verificarCasillero(Casillero unCasillero) {
		if (unCasillero.esCaminable() == false) {
			throw new CasilleroOcupadoError();
		}
	}
	
	public Casillero obtenerCasillero(Coordenada coord) {
		return this.TableroJuego.obtenerCasillero(coord);
	}

	public synchronized void agregarAlMapa(Personaje unPersonaje) {
		
		Coordenada coordenada = unPersonaje.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unPersonaje);
		this.agregarCasillero(coordenada, CasilleroAux);
	}
	
	public synchronized void agregarAlMapa(Obstaculo obstaculo) {
		
		Coordenada coordenada = obstaculo.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(obstaculo);
		this.agregarCasillero(coordenada, CasilleroAux);
	}
	
	public synchronized void agregarAlMapa(Armamento unArmamento) {
		
		Coordenada coordenada = unArmamento.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unArmamento);
		this.agregarCasillero(coordenada, CasilleroAux);
	}

	public synchronized void agregarAlMapa(Articulable unArticulo) {
		Coordenada coord = unArticulo.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coord);
		CasilleroAux.agregar(unArticulo);
		this.agregarCasillero(coord, CasilleroAux);
	}

	public synchronized void vivir() {
		int j,k;
		for(j=0;j < TableroJuego.obtenerTamanio(); j++){
			for(k=0;k < TableroJuego.obtenerTamanio(); k++){
				Coordenada unaCoordenada = new Coordenada(j,k);
				Casillero casillero = TableroJuego.obtenerCasillero(unaCoordenada);
				casillero.actualizar();
				this.puntajeTotal = puntajeTotal + casillero.obtenerPuntaje();
			}
		}
	}	
	public int obtenerPuntajeTotal(){
		return puntajeTotal;
	}
	
	
	public int obtenerTamanio(){
		return TableroJuego.obtenerTamanio();
	}

	public Element guardar() {
		Element elemMapa = DocumentHelper.createElement("Anotador");
		for(int j = 0; j < this.obtenerTamanio();j++){
			for(int k = 0; k < this.obtenerTamanio();k++){
				Coordenada coordenada = new Coordenada(j,k);
				Casillero CasilleroAux = this.obtenerCasillero(coordenada);
	            elemMapa.add(CasilleroAux.guardar());
			}
		}
        return elemMapa;
	}
	
	
}