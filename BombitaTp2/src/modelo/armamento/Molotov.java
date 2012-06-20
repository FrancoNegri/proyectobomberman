package modelo.armamento;

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
}
