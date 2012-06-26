package modelo.obstaculos;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class BloqueCemento extends Obstaculo {

	public BloqueCemento(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_cemento,unacoordenada);
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBloqueCemento(this);
	}
	
	public Element guardar() {
		Element elemBloque = super.guardar();
		elemBloque.addAttribute("Tipo", "BloqueCemento");
		return elemBloque;
	}
	
	public BloqueCemento recuperar(Element elemCemento, Mapa mapa ){
		
		Coordenada posicionBloque = Coordenada.recuperar(elemCemento.element("Coordenada"));
		BloqueCemento bloqueNuevo = new BloqueCemento(posicionBloque);
		bloqueNuevo.vida = Integer.parseInt(elemCemento.attributeValue("Vida"));
		return bloqueNuevo;
	}
	
}
