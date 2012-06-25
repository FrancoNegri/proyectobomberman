package modelo.personaje.enemigos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Enemigo;
import modelo.personaje.Personaje;

public class Cecilio extends Enemigo {

	public Cecilio(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		this.CreadorDeBombas = new MolotovFactory();
		this.vida = ConstantesJuego.vida_lopez_cecilio;
		this.velocidad = ConstantesJuego.velocidad_cecilio;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.interactuarConCecilio(this);
	}

	public Element guardar() {
		Element elemPersonaje = DocumentHelper.createElement("Cecilio");
		elemPersonaje=  super.guardar(elemPersonaje);
		return elemPersonaje;
	}

	public static Personaje recuperar(Element elemCes) {

	return null;
	}
}
