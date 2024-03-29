package modelo.armamento;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;

public class ToleTole extends Armamento{

	private int puntaje;
	
	public ToleTole(Coordenada coordenada,Mapa mapa ,int unTime) {
		super(coordenada,mapa);
		this.time = unTime;
		this.radio = ConstantesJuego.radio_toletole;
		this.puntaje = ConstantesJuego.puntaje_articulos;
	}

	
	public int obtenerPuntaje() {
		return puntaje;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConToleTole(this);
	}
	
	public Element guardar() {
		
		Element elemMolotov = DocumentHelper.createElement("ToleTole");
		super.guardar(elemMolotov);
		return elemMolotov;
	}
	
	public static ToleTole recuperar(Element elemArmamento,Mapa mapa){
		
		Coordenada posicionBomba = Coordenada.recuperar(elemArmamento.element(new QName("Coordenada")));
		int time = Integer.parseInt(elemArmamento.attributeValue(new QName("Time")));
		ToleTole bombaRecuperada = new ToleTole(posicionBomba,mapa,time);
		bombaRecuperada.danio = Integer.parseInt(elemArmamento.attributeValue(new QName("Danio")));
		bombaRecuperada.radio = Integer.parseInt(elemArmamento.attributeValue(new QName("Radio")));
		bombaRecuperada.exploto = Boolean.parseBoolean(elemArmamento.attributeValue(new QName("Exploto")));
		return bombaRecuperada;
	}
}
