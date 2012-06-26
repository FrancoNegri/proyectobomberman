package modelo.personaje.enemigos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
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
		super.guardar(elemPersonaje);
		return elemPersonaje;
	}
	
	private Cecilio() {
	}

	public static Personaje recuperar(Element elemCes,Mapa mapa) {
	Cecilio nuevoPers = new Cecilio();
	nuevoPers.vida = Integer.parseInt(elemCes.attributeValue((new QName("Vida"))));
	nuevoPers.coordenadaXY  = Coordenada.recuperar(elemCes.element(new QName("Coordenada")));
	nuevoPers.mapa = mapa;
	nuevoPers.CreadorDeBombas = new MolotovFactory();
	nuevoPers.velocidad = ConstantesJuego.velocidad_cecilio;
	nuevoPers.ultimaTranslacion = new TranslacionDerecha();
	return nuevoPers;
	}

}
