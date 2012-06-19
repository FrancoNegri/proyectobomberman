package modelo.armamento;

import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

public class Molotov extends Armamento{

	public Molotov(Coordenada coordenada,int Time){
		super(coordenada);
		this.danio = ConstantesJuego.danio_molotov;
		this.radio = ConstantesJuego.radio_molotov;
		this.time = Time; 
	}
}
