package modelo.armamento;

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
}
