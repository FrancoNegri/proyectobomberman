package modelo.obstaculos;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

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
	
}
