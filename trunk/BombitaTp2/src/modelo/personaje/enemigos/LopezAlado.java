package modelo.personaje.enemigos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.Translacion.TranslacionDerecha;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;

public class LopezAlado extends Enemigo {

	public LopezAlado(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		this.CreadorDeBombas = new MolotovFactory();
		this.vida = ConstantesJuego.vida_lopez_reggae_alado;
		this.velocidad = ConstantesJuego.velocidad_lopez_reggae_alado;
	}
	
	private LopezAlado(){
	}
	

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConLopezAlado(this);
	}
	
	public Element guardar() {
		Element elemPersonaje = DocumentHelper.createElement("LopezAlado");
		elemPersonaje=  super.guardar(elemPersonaje);
		return elemPersonaje;
	}
	
	public static Personaje recuperar(Element elemCes,Mapa mapa) {
		LopezAlado nuevoPers = new LopezAlado();
		nuevoPers.coordenadaXY  = Coordenada.recuperar(elemCes);
		nuevoPers.mapa = mapa;
		nuevoPers.CreadorDeBombas = new MolotovFactory();
		nuevoPers.velocidad = ConstantesJuego.velocidad_cecilio;
		nuevoPers.ultimaTranslacion = new TranslacionDerecha();
		return nuevoPers;
	}
}
