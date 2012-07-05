package modelo.Translacion;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import modelo.coordenadas.Coordenada;

public class TranslacionIzquierda extends Translacion {
	@Override
	protected Coordenada actuar(Coordenada cordenada, Coordenada nuevaCord) {
		nuevaCord.cambiarCoordenadaX(cordenada.obtenerCoordenadaX()-1);
		return nuevaCord;
	}
	
	@Override
	public Element guardar() {
		Element elemTranslacion = DocumentHelper.createElement("TranslacionIzquierda");
		return elemTranslacion;
	}
}
