package modelo.articulo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.armamento.Armamento;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Personaje;

public class ArticuloToleTole extends Articulo {

	public ArticuloToleTole(Coordenada unaCoordenada) {
		super(unaCoordenada);
	}

	public Element guardar() {
		Element elemArtMolotov = DocumentHelper.createElement("ArticuloToleTole");
		super.guardar(elemArtMolotov);
		return elemArtMolotov;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConToleTole(this);
	}

	@Override
	public void usar(Personaje unPersonaje){
		ToleToleFactory nuevaFactory = new ToleToleFactory();
		unPersonaje.cambiarArmamento(nuevaFactory);
	}

	public static Articulo recuperar(Element elemCes, Mapa nuevoMapa) {
		Coordenada coordenada = Coordenada.recuperar(elemCes.element(new QName ("Coordenada")));
		Articulo artToleTole = new ArticuloToleTole(coordenada);
		return artToleTole;
	}
	
	
}
