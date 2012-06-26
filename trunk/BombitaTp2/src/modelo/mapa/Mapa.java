package modelo.mapa;

import org.dom4j.Element;
import org.dom4j.Node;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.armamento.Proyectil;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulable;
import modelo.articulo.Articulo;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.errores.CasilleroOcupadoError;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueCemento;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;
import modelo.personaje.enemigos.LopezAlado;
import modelo.personaje.enemigos.LopezComun;
import modelo.articulo.Habano;
import modelo.articulo.Timer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Mapa implements ObjetoVivo {
	private Tablero TableroJuego;
	int puntajeTotal;

	public Mapa(int tamanio) {
		this.TableroJuego = new Tablero(tamanio);
	}

	public Mapa() {
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
	
	public Armamento ObtenerArmamento(Coordenada coord){
		return	this.TableroJuego.obtenerCasillero(coord).obtenerArmamento();
	}
	
	public LinkedList<Personaje> ObtenerPersonaje(Coordenada coord){
		return	this.TableroJuego.obtenerCasillero(coord).obtenerPersonajes();
	}
	
	public Obstaculo ObtenerObstaculo(Coordenada coord){
		return	this.TableroJuego.obtenerCasillero(coord).obtenerObstaculo();
	}
	
	public Articulable ObtenerArticulo(Coordenada coord){
		return	this.TableroJuego.obtenerCasillero(coord).obtenerArticulo();
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
		int j, k;
		for (j = 0; j < TableroJuego.obtenerTamanio(); j++) {
			for (k = 0; k < TableroJuego.obtenerTamanio(); k++) {
				Coordenada unaCoordenada = new Coordenada(j, k);
				Casillero casillero = TableroJuego
						.obtenerCasillero(unaCoordenada);
				casillero.actualizar();
				this.puntajeTotal = puntajeTotal + casillero.obtenerPuntaje();
			}
		}
	}

	public int obtenerPuntajeTotal() {
		return puntajeTotal;
	}

	public int obtenerTamanio() {
		return TableroJuego.obtenerTamanio();
	}

	
	//Refactorizar!!!!
	public Element guardar() {
		Element elemMapa = DocumentHelper.createElement("Mapa");
		elemMapa.addAttribute("Tamanio",
				String.valueOf(TableroJuego.obtenerTamanio()));
		Element elemPersonajes = DocumentHelper.createElement("Personajes");
		Element elemBloques = DocumentHelper.createElement("Bloques");
		Element elemArmamentos = DocumentHelper.createElement("Armamentos");
		Element elemArticulos = DocumentHelper.createElement("Articulos");
		for (int j = 0; j < this.obtenerTamanio(); j++) {
			for (int k = 0; k < this.obtenerTamanio(); k++) {
				Coordenada coordenada = new Coordenada(j, k);
				Casillero CasilleroAux = this.obtenerCasillero(coordenada);

				Iterator<Personaje> it = CasilleroAux.obtenerPersonajes()
						.iterator();
				while (it.hasNext()) {
					Personaje personajeAguardar = it.next();
					elemPersonajes.add(personajeAguardar.guardar());

				}
				Armamento arma = CasilleroAux.obtenerArmamento();
				if (arma != null) {
					elemArmamentos.add(arma.guardar());
				}
				Articulable articulo = CasilleroAux.obtenerArticulo();
				if (articulo != null) {
					elemArticulos.add(articulo.guardar());
				}
				Obstaculo obstaculo = CasilleroAux.obtenerObstaculo();
				if (obstaculo != null) {
					elemBloques.add(obstaculo.guardar());
				}
			}
		}
		elemMapa.add(elemPersonajes);
		elemMapa.add(elemBloques);
		elemMapa.add(elemArmamentos);
		elemMapa.add(elemArticulos);
		return elemMapa;
	}
}