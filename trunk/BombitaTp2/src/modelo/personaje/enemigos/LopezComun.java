package modelo.personaje.enemigos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.Translacion.TranslacionDerecha;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Enemigo;
import modelo.personaje.Personaje;

public class LopezComun extends Enemigo {
	
	public LopezComun(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		CreadorDeBombas = new ProyectilFactory();
		this.velocidad = ConstantesJuego.velocidad_lopez_reggae_comun;
		this.vida = ConstantesJuego.vida_lopez_reggae_comun;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConLopezComun(this);
	}
	
	public Element guardar() {
		Element elemPersonaje = DocumentHelper.createElement("Cecilio");
		elemPersonaje=  super.guardar(elemPersonaje);
		return elemPersonaje;
	}
	
	private LopezComun(){
	}
	
	public static Personaje recuperar(Element elemCes,Mapa mapa) {
		LopezComun nuevoPers = new LopezComun();
		nuevoPers.coordenadaXY  = Coordenada.recuperar(elemCes);
		nuevoPers.mapa = mapa;
		nuevoPers.CreadorDeBombas = new MolotovFactory();
		nuevoPers.velocidad = ConstantesJuego.velocidad_cecilio;
		nuevoPers.ultimaTranslacion = new TranslacionDerecha();
		return nuevoPers;
	}
	
}
