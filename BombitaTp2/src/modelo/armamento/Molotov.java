package modelo.armamento;

import modelo.coordenadas.Coordenada;

public class Molotov extends Armamento{

	public Molotov(Coordenada coordenada,int Time){
		super(coordenada);
		danio = 1;
		radio = 3;
		this.time = Time;
	}
}
