package modelo.obstaculos;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;

public class BloqueAcero extends Obstaculo {

	public BloqueAcero(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_Acero,unacoordenada);
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBloqueAcero(this);
	}
	
	//se Podria hacer un doble Dispatch o algo para ver si es una tole tole o otra arma

	
	public Element guardar() {
		Element elemBloque = super.guardar();
		elemBloque.addAttribute("Tipo", "BloqueAcero");
		return elemBloque;
	}
}
