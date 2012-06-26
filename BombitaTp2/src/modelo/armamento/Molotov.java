package modelo.armamento;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

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
		Element elemMolotov = DocumentHelper.createElement("Molotov");
		super.guardar(elemMolotov);
		return elemMolotov;
	}
	
	public static Molotov recuperar(Element elemArmamento,Mapa mapa){
		
		Coordenada posicionBomba = Coordenada.recuperar(elemArmamento.element(new QName("Coordenada")));
		int time = Integer.parseInt(elemArmamento.attributeValue(new QName("Time")));
		Molotov bombaRecuperada = new Molotov(posicionBomba,mapa,time);
		bombaRecuperada.danio = Integer.parseInt(elemArmamento.attributeValue(new QName("Danio")));
		bombaRecuperada.radio = Integer.parseInt(elemArmamento.attributeValue(new QName("Radio")));
		bombaRecuperada.exploto = Boolean.parseBoolean(elemArmamento.attributeValue(new QName("Exploto")));
		return bombaRecuperada;
		
		
	}
	
}
