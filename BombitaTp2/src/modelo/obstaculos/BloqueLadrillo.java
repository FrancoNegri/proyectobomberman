package modelo.obstaculos;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

public class BloqueLadrillo extends Obstaculo{

	public BloqueLadrillo(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_ladrillo,unacoordenada);
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBloqueLadrillo(this);
	}
	
	public Element guardar() {
		Element elemBloque = super.guardar();
		elemBloque.addAttribute("Tipo", "BloqueLadrillo");
		return elemBloque;
	}
}
	