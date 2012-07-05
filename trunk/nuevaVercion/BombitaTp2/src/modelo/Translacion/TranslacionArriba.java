package modelo.Translacion;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import modelo.coordenadas.Coordenada;

public class TranslacionArriba extends Translacion {
	@Override
	protected Coordenada actuar(Coordenada cordenada,Coordenada nuevaCord){
		nuevaCord.cambiarCoordenadaY(cordenada.obtenerCoordenadaY()+1);
		return nuevaCord;
	}
	
	
	@Override
	public Element guardar() {
		Element elemTranslacion = DocumentHelper.createElement("TranslacionArriba");
		return elemTranslacion;
	}
}
