package modelo.obstaculos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;
import modelo.mapa.Mapa;

public class BloqueAcero extends Obstaculo {

	public BloqueAcero(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_Acero,unacoordenada);
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBloqueAcero(this);
	}
	
	//se Podria hacer un doble Dispatch o algo para ver si es una tole tole o otra arma

	
	public Element guardar() {
		Element elemBloque = DocumentHelper.createElement("BloqueDeAcero");
		super.guardar(elemBloque);
		return elemBloque;
	}
	
    public static BloqueAcero recuperar(Element elemAcero, Mapa mapa ){
		
		Coordenada posicionBloque = Coordenada.recuperar(elemAcero.element(new QName("Coordenada")));
		BloqueAcero bloqueNuevo = new BloqueAcero(posicionBloque);
		bloqueNuevo.vida = Integer.parseInt(elemAcero.attributeValue(new QName("Vida")));
		return bloqueNuevo;
	}
	
}
