package control.Persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.armamento.Proyectil;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.articulo.Timer;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueCemento;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Bombita;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;
import modelo.personaje.enemigos.LopezAlado;
import modelo.personaje.enemigos.LopezComun;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Persistencia {

	Personaje bombita;
	
	public void guardar(String archivo, Mapa mapa) {
		Document doc = DocumentHelper.createDocument();
		doc.add(mapa.guardar());
		FileWriter writer;
		try {
			writer = new FileWriter(archivo);
			doc.write(writer);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Mapa recuperar(String archivo) throws IOException {
		SAXReader reader = new SAXReader();
		try {

			Document document = reader.read(archivo);
			Element elemMapa = document.getRootElement();
			return this.recuperar(elemMapa);
		} catch (DocumentException ex) {
			throw new IOException();
		}
	}

	private Mapa recuperar(Element elemMapa) {
		Mapa nuevoMapa = new Mapa(Integer.parseInt(elemMapa
				.attributeValue("Tamanio")));
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

	// metodos privados para recuperar los distintos elementos del nivel.

	private void recuperarPersonajes(Element Personajes, Mapa nuevoMapa) {
		Iterator<Element> ItPers = Personajes.elementIterator();
		while (ItPers.hasNext()) {
			Element ElemCes = ItPers.next();
			if (ElemCes.getName() == "Cecilio") {
				Personaje pers = Cecilio.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(pers);
			}
			if (ElemCes.getName() == "LopezAlado") {
				Personaje pers = LopezAlado.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(pers);
			}
			if (ElemCes.getName() == "LopezComun") {
				Personaje pers = LopezComun.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(pers);
			}
			if (ElemCes.getName() == "Bombita") {
				bombita = Bombita.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(bombita);
			}
		}
	}

	// modificar
	private void recuperarObstaculos(Element Obstaculos, Mapa nuevoMapa) {
		Iterator<Element> ItBloques = Obstaculos.elementIterator();
		while (ItBloques.hasNext()) {
			Element ElemCes = ItBloques.next();
			if (ElemCes.getName() == "BloqueDeCemento") {
				Obstaculo bloque = BloqueCemento.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(bloque);
			}
			if (ElemCes.getName() == "BloqueDeAcero") {
				Obstaculo bloque = BloqueAcero.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(bloque);
			}
			if (ElemCes.getName() == "BloqueDeLadrillos") {
				Obstaculo bloque = BloqueLadrillo.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(bloque);
			}
		}
	}

	private void recuperarArmamentos(Element Armamentos, Mapa nuevoMapa) {
		Iterator<Element> ItBloques = Armamentos.elementIterator();
		while (ItBloques.hasNext()) {
			Element ElemCes = ItBloques.next();
			if (ElemCes.getName() == "Proyectil") {
				Armamento arma = Proyectil.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(arma);
			}
			if (ElemCes.getName() == "ToleTole") {
				Armamento arma = ToleTole.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(arma);
			}
			if (ElemCes.getName() == "Molotov") {
				Armamento arma = Molotov.recuperar(ElemCes, nuevoMapa);
				nuevoMapa.agregarAlMapa(arma);
			}
		}
	}

	private void recuperarArticulos(Element Articulos, Mapa nuevoMapa) {
		Iterator<Element> ItArticulos = Articulos.elementIterator();
		while (ItArticulos.hasNext()) {
			Element ElemCes = ItArticulos.next();
			if (ElemCes.getName() == "Habano") {
				Articulo Art = Habano.recuperar(ElemCes);
				nuevoMapa.agregarAlMapa(Art);
			}
			if (ElemCes.getName() == "Timer") {
				Articulo Art = Timer.recuperar(ElemCes);
				nuevoMapa.agregarAlMapa(Art);
			}

		}
	}

	public Bombita recuperarBombita() {
		return (Bombita) bombita;
	}
}
