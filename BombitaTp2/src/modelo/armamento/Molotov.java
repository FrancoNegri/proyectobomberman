package modelo.armamento;

import org.dom4j.Element;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class Molotov extends Armamento{

	public Molotov(Coordenada coordenada,Mapa mapa ,int Time){
		super(coordenada,mapa);
		this.danio = ConstantesJuego.danio_molotov;
		this.radio = ConstantesJuego.radio_molotov;
		this.time = Time; 
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConMolotov(this);
	}
	
	public Element guardar() {
		Element elemMolotov = super.guardar();
		elemMolotov.addAttribute("Tipo", "Molotov");
		return elemMolotov;
	}
	
	public Molotov recuperar(Element elemArmamento,Mapa mapa){
		
		Coordenada posicionBomba = Coordenada.recuperar(elemArmamento.element("Coordenada"));
		int time = Integer.parseInt(elemArmamento.attributeValue("Time"));
		Molotov bombaRecuperada = new Molotov(posicionBomba,mapa,time);
		bombaRecuperada.danio = Integer.parseInt(elemArmamento.attributeValue("Danio"));
		bombaRecuperada.radio = Integer.parseInt(elemArmamento.attributeValue("Radio"));
		bombaRecuperada.exploto = Boolean.parseBoolean(elemArmamento.attributeValue("Exploto"));
		return bombaRecuperada;
		
		
	}
	
}
