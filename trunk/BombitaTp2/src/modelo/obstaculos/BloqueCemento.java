package modelo.obstaculos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class BloqueCemento extends Obstaculo {

	public BloqueCemento(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_cemento, unacoordenada);
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBloqueCemento(this);
	}

	public Element guardar() {
		Element elemBloque = DocumentHelper.createElement("BloqueDeCemento");
		super.guardar(elemBloque);
		return elemBloque;
	}

	public static BloqueCemento recuperar(Element elemCemento, Mapa mapa) {

		Coordenada posicionBloque = Coordenada.recuperar(elemCemento
				.element(new QName("Coordenada")));
		BloqueCemento bloqueNuevo = new BloqueCemento(posicionBloque);
		bloqueNuevo.vida = Integer.parseInt(elemCemento
				.attributeValue(new QName("Vida")));
		return bloqueNuevo;
	}

}
