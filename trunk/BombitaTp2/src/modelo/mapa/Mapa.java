package modelo.mapa;

import org.dom4j.Element;
import org.dom4j.Node;

import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import modelo.armamento.Armamento;
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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import java.util.Iterator;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import control.Persistencia.ObjetoRecuperable;
import control.Persistencia.Recuperador;

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

	
	
	
	
	public Mapa recuperar(Element elemMapa) {
		Mapa nuevoMapa = new Mapa(Integer.parseInt(elemMapa.attributeValue("Tamanio")));
		Element Personajes = elemMapa.element("Personajes");
		Element Obstaculos = elemMapa.element("Bloques");
		Element Articulos = elemMapa.element("Articulos");
		Element Armamentos = elemMapa.element("Armamentos");
		
		this.recuperarPersonajes(Personajes, nuevoMapa);
		this.recuperarObstaculos(Obstaculos, nuevoMapa);
		this.recuperarArticulos(Articulos, nuevoMapa);
		this.recuperarArmamentos(Armamentos, nuevoMapa);
		
		return nuevoMapa;
	}
 



//metodos privados para recuperar los distintos elementos del nivel.

private void recuperarPersonajes(Element Personajes, Mapa nuevoMapa){
	Iterator ItPers =  Personajes.elementIterator();
	while(ItPers.hasNext()){
		Element ElemCes = (Element) ItPers.next();
		if(ElemCes.getName()=="Cecilio"){
			Personaje pers = Cecilio.recuperar(ElemCes,nuevoMapa);
			nuevoMapa.agregarAlMapa(pers);	
		}
		if(ElemCes.getName()=="LopezAlado"){
			Personaje pers = LopezAlado.recuperar(ElemCes,nuevoMapa);
			nuevoMapa.agregarAlMapa(pers);	
		}
		if(ElemCes.getName()=="LopezComun"){
			Personaje pers = LopezComun.recuperar(ElemCes,nuevoMapa);
			nuevoMapa.agregarAlMapa(pers);	
		}
	}
}


//modificar
private void recuperarObstaculos(Element Obstaculos, Mapa nuevoMapa){

	Iterator ItPers =  Obstaculos.elementIterator();
	while(ItPers.hasNext()){
		Element ElemCes = (Element) ItPers.next();
		if(ElemCes.getName()=="Bloque de Cemento"){
			Obstaculo pers = BloqueCemento.recuperar(ElemCes,nuevoMapa);
			nuevoMapa.agregarAlMapa(pers);	
		}
		if(ElemCes.getName()=="Bloque de Acero"){
			Obstaculo pers = BloqueAcero.recuperar(ElemCes,nuevoMapa);
			nuevoMapa.agregarAlMapa(pers);	
		}
		if(ElemCes.getName()=="Bloque de Ladrillos"){
			Obstaculo pers = BloqueLadrillo.recuperar(ElemCes,nuevoMapa);
			nuevoMapa.agregarAlMapa(pers);	
		}
	}
}

private void recuperarArmamentos(Element Armamentos, Mapa nuevoMapa){
	
}

private void recuperarArticulos(Element Articulos,Mapa nuevoMapa){
	
}


}