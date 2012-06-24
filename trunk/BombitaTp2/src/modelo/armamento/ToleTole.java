package modelo.armamento;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;

public class ToleTole extends Armamento implements Articulable {

	private int puntaje;
	
	public ToleTole(Coordenada coordenada,Mapa mapa ,int unTime) {
		super(coordenada,mapa);
		this.time = unTime;
		this.radio = ConstantesJuego.radio_toletole;
		this.puntaje = ConstantesJuego.puntaje_articulos;
	}
	
	public void usar(Personaje unPersonaje){
		
			ToleToleFactory nuevaFactory = new ToleToleFactory();
			unPersonaje.cambiarArmamento(nuevaFactory);
	}
	

	
	public int obtenerPuntaje() {
		return puntaje;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConToleTole(this);
	}
	
	public Element guardar() {
		Element elemMolotov = super.guardar();
		elemMolotov.addAttribute("Tipo", "ToleTole");
		return elemMolotov;
	}
	
}
