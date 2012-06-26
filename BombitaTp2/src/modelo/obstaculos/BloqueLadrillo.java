package modelo.obstaculos;

import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.*;


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
	
	public BloqueLadrillo recuperar(Element elemLadrillo, Mapa mapa ){
		
		Coordenada posicionBloque = Coordenada.recuperar(elemLadrillo.element(new QName("Coordenada")));
		BloqueLadrillo bloqueNuevo = new BloqueLadrillo(posicionBloque);
		bloqueNuevo.vida = Integer.parseInt(elemLadrillo.attributeValue(new QName("Vida")));
		return bloqueNuevo;
	}
}
	